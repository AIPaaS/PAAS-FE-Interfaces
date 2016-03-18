package com.aic.paas.task.dep.msg.receive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.ParmDockerImage;
import com.aic.paas.task.dep.bean.PcAppDepInstance;
import com.aic.paas.task.dep.peer.PcAppDepInstancePeer;
import com.aic.paas.task.dep.rest.PcAppAccessSvc;
import com.aic.paas.task.msg.receive.NsqReceiveHandler;
import com.binary.core.util.BinaryUtils;
import com.binary.json.JSON;

public class AppDepInstanceReceive implements NsqReceiveHandler {
	private static final Logger logger = LoggerFactory.getLogger(AppDepInstanceReceive.class);
	private static final String STATUS_KILLED = "KILLED";
	private static final String STATUS_RUNNING = "RUNNING";

	@Autowired
	PcAppDepInstancePeer depInstancePeer;

	@Autowired
	PcAppAccessSvc pcAppAccessSvc;

	private String topicName;
	private String channelName;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public void receive(String msg) {
		logger.info(" =============================== : " + msg);

		ParmDockerImage dockerIntstance = JSON.toObject(msg, ParmDockerImage.class);

		if (dockerIntstance == null) return;

		// 校验必填字段
		if (!checkParam(dockerIntstance)) return;

		// 1
		processDepInstance(dockerIntstance);

		// 2
		processPcAppAccess(dockerIntstance);
	}

	private void processPcAppAccess(ParmDockerImage dockerIntstance) {
		pcAppAccessSvc.remoteMonitorService(dockerIntstance);
	}

	private void processDepInstance(ParmDockerImage dockerIntstance) {

		if (dockerIntstance.getTaskStatus().equals(STATUS_KILLED)) {
			depInstancePeer.disableDepInstanceByInstanceName(dockerIntstance.getDockerName());
		} else if (dockerIntstance.getTaskStatus().equals(STATUS_RUNNING)) {
			try {
				PcAppDepInstance record = new PcAppDepInstance();
				record.setServerIp(dockerIntstance.getHost());
				record.setInstanceName(dockerIntstance.getDockerName());
				Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,sss").parse(dockerIntstance.getTimestamp());
				record.setTime(time.getTime());
				depInstancePeer.addDepInstanceByAppImgFullName(dockerIntstance.getDockerImage(), record);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean checkParam(ParmDockerImage dockerIntstance) {

		if (BinaryUtils.isEmpty(dockerIntstance.getTaskStatus())) {
			return false;
		}

		if (BinaryUtils.isEmpty(dockerIntstance.getDockerName())) {
			return false;
		}

		if (BinaryUtils.isEmpty(dockerIntstance.getDockerImage())) {
			return false;
		}

		if (BinaryUtils.isEmpty(dockerIntstance.getHost())) {
			return false;
		}

		if (BinaryUtils.isEmpty(dockerIntstance.getTimestamp())) {
			return false;
		}
		return true;
	}

}

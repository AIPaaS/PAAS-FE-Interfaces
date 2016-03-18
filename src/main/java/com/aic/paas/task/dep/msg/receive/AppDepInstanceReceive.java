package com.aic.paas.task.dep.msg.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.PcAppDepInstance;
import com.aic.paas.task.dep.peer.PcAppDepInstancePeer;
import com.aic.paas.task.msg.receive.NsqReceiveHandler;
import com.binary.core.util.BinaryUtils;

public class AppDepInstanceReceive implements NsqReceiveHandler {
	private static final Logger logger = LoggerFactory.getLogger(AppDepInstanceReceive.class);
	
	
	@Autowired
	PcAppDepInstancePeer depInstancePeer;
	
	
	
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
		
//		depInstancePeer.disableDepInstanceByInstanceName(instanceName)
//		
//		PcAppDepInstance record)
//		depInstancePeer.addDepInstanceByAppImgFullName(appImgFullName, record)
//		BinaryUtils.getNumberDate(date)
		logger.info(" =============================== : " + msg);
	}

}

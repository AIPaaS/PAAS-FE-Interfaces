package com.aic.paas.task.mvc.dep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.bean.dep.PcApp;
import com.aic.paas.task.bean.dep.PcAppDepHistory;
import com.aic.paas.task.bean.dep.PcAppDepInstance;
import com.aic.paas.task.bean.dep.PcAppTask;
import com.aic.paas.task.mvc.dep.bean.ActionType;
import com.aic.paas.task.mvc.dep.bean.CallBackReq;
import com.aic.paas.task.mvc.dep.bean.InstanceStateType;
import com.aic.paas.task.rest.dep.PcAppDepHistorySvc;
import com.aic.paas.task.rest.dep.PcAppDepInstanceSvc;
import com.aic.paas.task.rest.dep.PcAppSvc;
import com.aic.paas.task.rest.dep.PcAppTaskSvc;
import com.aic.paas.task.rest.dep.PcAppVersionSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.json.JSON;

@Controller
@RequestMapping("/deploy")
public class CallbackMvc {
	static final Logger logger = LoggerFactory.getLogger(CallbackMvc.class);
	@Autowired
	PcAppSvc pcAppSvc;

	@Autowired
	PcAppTaskSvc pcAppTaskSvc;

	@Autowired
	PcAppVersionSvc pcAppVersionSvc;

	@Autowired
	PcAppDepHistorySvc pcAppDepHistorySvc;

	@Autowired
	PcAppDepInstanceSvc pcAppDepInstanceSvc;

	@RequestMapping("/callback")
	public void callDeployServiceFinished(HttpServletRequest request, HttpServletResponse response, @RequestBody String param) {
		logger.info("receive callback request , param is " + param);
		CallBackReq callBackReq = JSON.toObject(param, CallBackReq.class);

		if (ActionType.deploy.getName().equals(callBackReq.getActionType())) {
			afterStart(callBackReq, 3);
		} else if (ActionType.destroy.getName().equals(callBackReq.getActionType())) {
			afterStart(callBackReq, 1);
		} else if (ActionType.start.getName().equals(callBackReq.getActionType())) {
			afterStart(callBackReq, 3);
		} else if (ActionType.stop.getName().equals(callBackReq.getActionType())) {
			afterStart(callBackReq, 4);
		} else if (ActionType.upgrade.getName().equals(callBackReq.getActionType())) {
			afterStart(callBackReq, 3);
		}
		ControllerUtils.returnJson(request, response, true);
	}

	private void afterStart(CallBackReq callBackReq, int pcAppStatus) {
		PcAppTask pcAppTask = pcAppTaskSvc.queryById(callBackReq.getReqId());
		Map<String, Long> idMap = getAppDepHistoryIdoiMap(callBackReq.getReqId().longValue());
		int state = -1;
		for (CallBackReq.Container container : callBackReq.getContainers()) {
			String containerName = container.getContainerName();
			Long appDepHistoryId = idMap.get(containerName);
			if (appDepHistoryId == null) {
				logger.error("cann't find app dep history id from container " + containerName);
				continue;
			}
			for (CallBackReq.Container.Instance instance : container.getInstances()) {
				PcAppDepInstance pcAppDepInstance = new PcAppDepInstance();
				pcAppDepInstance.setAppDepHistoryId(appDepHistoryId);
				pcAppDepInstance.setInstanceName(instance.getInstanceId());
				pcAppDepInstance.setServerIp(instance.getHost());
				pcAppDepInstanceSvc.saveOrUpdate(pcAppDepInstance);
				int stateKey = InstanceStateType.keyOf(instance.getState());
				if (stateKey > state)
					state = stateKey;
			}
		}
		PcApp pcApp = pcAppSvc.queryById(Long.parseLong(callBackReq.getAppId()));
		if (state == InstanceStateType.RUNNING.getKey()) {
			pcApp.setStatus(pcAppStatus);
			pcAppTask.setStatus(3);
		} else if ((state == InstanceStateType.STAGING.getKey()) || (state == InstanceStateType.FAILED.getKey())) {
			// timeout failed
			pcApp.setStatus(5);
			pcAppTask.setStatus(4);
		} else {
			logger.info("no container callback , app is " + callBackReq.getAppId());
			if (ActionType.destroy.getName().equals(callBackReq.getActionType())) {
				pcApp.setStatus(1);
			} else
				pcApp.setStatus(4);
			pcAppTask.setStatus(3);
		}
		pcAppTask.setTaskEndTime(BinaryUtils.getNumberDateTime());
		pcAppSvc.saveOrUpdate(pcApp);
		pcAppTaskSvc.update(pcAppTask);
	}

	private Map<String, Long> getAppDepHistoryIdoiMap(long taskId) {
		Map<String, Long> result = new HashMap<>();
		List<PcAppDepHistory> appDepHistorys = pcAppDepHistorySvc.queryByTaskId(taskId);
		if (CollectionUtils.isNotEmpty(appDepHistorys)) {
			for (PcAppDepHistory pcAppDepHistory : appDepHistorys) {
				result.put(pcAppDepHistory.getContainerName(), pcAppDepHistory.getId());
			}
		}
		return result;
	}
}

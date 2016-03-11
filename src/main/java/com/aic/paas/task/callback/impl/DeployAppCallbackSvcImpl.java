package com.aic.paas.task.callback.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.PcAppTask;
import com.aic.paas.task.callback.ActionType;
import com.aic.paas.task.callback.CallBackReq;
import com.aic.paas.task.callback.DeployAppCallbackSvc;
import com.aic.paas.task.rest.dep.PcAppSvc;
import com.aic.paas.task.rest.dep.PcAppTaskSvc;
import com.binary.json.JSON;

public class DeployAppCallbackSvcImpl implements DeployAppCallbackSvc {

	@Autowired
	PcAppSvc pcAppSvc;

	@Autowired
	PcAppTaskSvc pcAppTaskSvc;

	@Override
	public void callDeployServiceFinished(String param) {
		CallBackReq callBackReq = JSON.toObject(param, CallBackReq.class);

		if (ActionType.deploy.equals(callBackReq.getActionType())) {
			PcAppTask pcAppTask = pcAppTaskSvc.queryById(callBackReq.getReqId());
			// pcAppSvc.
		} else if (ActionType.destroy.equals(callBackReq.getActionType())) {

		} else {

		}
	}

}

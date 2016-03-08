package com.aic.paas.task.callback.impl;

import com.aic.paas.task.callback.CallBackReq;
import com.aic.paas.task.callback.DeployAppCallbackSvc;
import com.binary.json.JSON;

public class DeployAppCallbackSvcImpl implements DeployAppCallbackSvc {

	@Override
	public void callDeployServiceFinished(String param) {
		CallBackReq callBackReq = JSON.toObject(param, CallBackReq.class);
	}

}

package com.aic.paas.task.send.impl;

import com.aic.paas.task.send.MsgEntity;
import com.binary.json.JSON;

public class NsqHttpMessageSender extends AbstractMessageSender {

	
	
	
	
	@Override
	protected boolean sendMsg(MsgEntity msg) throws Throwable {
		System.out.println(" send msg to message queue: "+JSON.toString(msg));
		return true;
	}
	
	
	
	

}

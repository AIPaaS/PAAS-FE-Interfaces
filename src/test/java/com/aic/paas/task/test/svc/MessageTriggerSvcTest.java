package com.aic.paas.task.test.svc;

import org.junit.Before;
import org.junit.Test;

import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.svc.msmq.MessageTriggerSvc;
import com.binary.framework.test.TestTemplate;

public class MessageTriggerSvcTest extends TestTemplate {

	
	
	MessageTriggerSvc svc;
	
	
	@Before
	public void init() {
		svc = getBean(MessageTriggerSvc.class);
	}
	
	
	
	@Test
	public void sendAllMessage() throws Throwable {
		MsgType msgType = MsgType.APP;
		svc.sendAllMessage(msgType);
		
		
		
		Thread.sleep(10000);
	}
	
	
	
	
	
}

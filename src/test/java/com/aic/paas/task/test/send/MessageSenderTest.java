package com.aic.paas.task.test.send;

import com.aic.paas.task.bean.sys.SysOp;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.send.MessageSender;
import com.aic.paas.task.send.OpType;
import com.aic.paas.task.send.impl.NsqHttpMessageSender;

public class MessageSenderTest {
	
	
	
	public static void main(String[] args) {
		MessageSender sender = new NsqHttpMessageSender();
		SysOp op = new SysOp();
		op.setId(1l);
		op.setOpCode("test");
		op.setOpName("测试用户");
		sender.sendMessage(MsgType.USER, OpType.ADD, op);
	}

}

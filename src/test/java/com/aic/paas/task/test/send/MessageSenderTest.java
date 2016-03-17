package com.aic.paas.task.test.send;

import com.aic.paas.task.msg.send.MessageSender;
import com.aic.paas.task.msg.send.OpType;
import com.aic.paas.task.msg.send.impl.NsqHttpMessageSender;
import com.aic.paas.task.msg.send.msg.MsgType;
import com.aic.paas.task.sys.bean.SysOp;

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

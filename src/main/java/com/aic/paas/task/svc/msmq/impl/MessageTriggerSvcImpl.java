package com.aic.paas.task.svc.msmq.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.msg.Message;
import com.aic.paas.task.msg.MessageFactory;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.svc.msmq.MessageTriggerSvc;
import com.binary.core.bean.BMProxy;
import com.binary.core.lang.Conver;
import com.binary.core.thread.BinaryThreadPool;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.Local;
import com.binary.framework.bean.Condition;
import com.binary.framework.bean.User;
import com.binary.json.JSON;

public class MessageTriggerSvcImpl implements MessageTriggerSvc {
	private static Logger logger = LoggerFactory.getLogger(MessageTriggerSvcImpl.class);

	
	@Autowired
	MessageFactory messageFactory;
	
	
	private BinaryThreadPool threadPool;
	
	
	
	public BinaryThreadPool getThreadPool() {
		return threadPool;
	}
	public void setThreadPool(BinaryThreadPool threadPool) {
		this.threadPool = threadPool;
	}
	
	
	
	@Override
	public void sendMessageByIds(MsgType msgType, Long[] ids) {
		logger.info(" sendMessageByIds {msgType:"+msgType+", ids:["+Conver.toString(ids)+"]}");
		
		BinaryUtils.checkEmpty(msgType, "msgType");
		BinaryUtils.checkEmpty(ids, "ids");
		
		Message<?, Condition> msg = messageFactory.getMessage(msgType);
		BMProxy<Condition> cdtproxy = BMProxy.getInstance(msg.getConditionClass());
		Condition cdt = cdtproxy.newInstance();
		
		cdtproxy.set("ids", ids);
		
		sendMessage(msg, cdt);
	}
	
	
	
	@Override
	public void sendMessageByDate(MsgType msgType, Integer date) {
		logger.info(" sendMessageByIds {msgType:"+msgType+", date:"+date+"}");
		
		BinaryUtils.checkEmpty(msgType, "msgType");
		BinaryUtils.checkEmpty(date, "date");
		Long startTime = date.longValue()*1000000;
		Long endTime = startTime + 235959;
		sendMessageByTimeInterval(msgType, startTime, endTime);
	}
	
	
	
	@Override
	public void sendMessageByTimeInterval(MsgType msgType, Long startTime, Long endTime) {
		logger.info(" sendMessageByIds {msgType:"+msgType+", startTime:"+startTime+", endTime:"+endTime+"}");
		
		BinaryUtils.checkEmpty(msgType, "msgType");
		BinaryUtils.checkEmpty(startTime, "startTime");
		BinaryUtils.checkEmpty(endTime, "endTime");
		
		Message<?, Condition> msg = messageFactory.getMessage(msgType);
		BMProxy<Condition> cdtproxy = BMProxy.getInstance(msg.getConditionClass());
		Condition cdt = cdtproxy.newInstance();
		
		cdtproxy.set("startModifyTime", startTime);
		cdtproxy.set("endModifyTime", endTime);
		
		sendMessage(msg, cdt);
	}
	
	
	
	
	@Override
	public void sendAllMessage(MsgType msgType) {
		logger.info(" sendMessageByIds {msgType:"+msgType+"}");
		
		BinaryUtils.checkEmpty(msgType, "msgType");
		Message<?,?> msg = messageFactory.getMessage(msgType);
		sendMessage(msg, null);
	}
	
	
	
	
	private <T extends Condition> void sendMessage(final Message<?,T> msg, T cdt) {
		final T ecdt;
		
		BMProxy<T> cdtproxy = BMProxy.getInstance(msg.getConditionClass());
		if(cdt == null) {
			ecdt = cdtproxy.newInstance();
		}else {
			ecdt = cdt;
			cdtproxy.replaceInnerObject(cdt);
		}
		if(cdtproxy.containsKey("dataStatuss")) {
			cdtproxy.set("dataStatuss", new Integer[]{0,1});
		}
		
		threadPool.pushTask(new Runnable() {
			@Override
			public void run() {
				try {
					logger.info(" start sendMessage {"+JSON.toString(msg)+"}");
					try {
						Local.open((User)null);
						msg.sendMessageByCdt(ecdt);
						Local.commit();
					}finally {
						Local.close();
					}
				}catch(Throwable t) {
					logger.error(" sendMessage {"+JSON.toString(msg)+"} error! ", t);
				}
			}
		});
	}


	

}

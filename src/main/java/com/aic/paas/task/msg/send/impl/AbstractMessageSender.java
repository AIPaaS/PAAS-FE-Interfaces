package com.aic.paas.task.msg.send.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.msg.send.MessageHandler;
import com.aic.paas.task.msg.send.MessageSender;
import com.aic.paas.task.msg.send.MsgEntity;
import com.aic.paas.task.msg.send.OpType;
import com.aic.paas.task.msg.send.msg.MsgType;
import com.binary.core.bean.BMProxy;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.bean.EntityBean;
import com.binary.framework.exception.ServiceException;
import com.binary.json.JSON;

public abstract class AbstractMessageSender implements MessageSender {
	private static Logger logger = LoggerFactory.getLogger(MessageSender.class);
	
	
	
	/**
	 * 获取实体对象dataStatus字段值
	 * @param bean
	 * @return 没有dataStatus则返回null
	 */
	private <T extends EntityBean> Integer getDataStatusValue(T bean) {
		BMProxy<T> proxy = BMProxy.getInstance(bean);
		if(proxy.containsKey("dataStatus")) {
			return (Integer)proxy.get("dataStatus");
		}
		return null;
	}
	
	
	
	
	@Override
	public <T extends EntityBean> boolean sendMessage(MsgType msgType, T msg) {
		return sendMessage(msgType, msg, null);
	}
	
	
	
	
	/**
	 * 发送消息对象
	 * @param msgType 指定消息类型
	 * @param opType 操作类型
	 * @param obj 指定发送对象
	 * @param 消息转换对象
	 * @return
	 */
	public <T extends EntityBean> boolean sendMessage(MsgType msgType, T msg, MessageHandler<T> handler) {
		BinaryUtils.checkEmpty(msgType, "msgType");
		BinaryUtils.checkEmpty(msg, "msg");
		
		Long createTime = msg.getCreateTime();
		Long nodifyTime = msg.getModifyTime();
		Integer dataStatus = getDataStatusValue(msg);
		OpType opType = null;
		Object obj = msg;
		
		boolean delDataStatus = dataStatus!=null && dataStatus.intValue()==0;
		boolean sameTime = createTime.equals(nodifyTime);
		
		if(delDataStatus) {
			//删除
			opType = OpType.DEL;
		}else {
			if(sameTime) {
				opType = OpType.ADD;
			}else {
				opType = OpType.UPD;
			}
		}
		
		if(handler != null) {
			obj = handler.correctMessage(opType, msg);
			if(obj == null) throw new ServiceException(" the correct message result is NULL! ");
		}else {
			if(delDataStatus) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", msg.getId());
			}
		}
		
		return sendMessage(msgType, opType, obj, null);
	}
	
	
	@Override
	public boolean sendMessage(MsgType msgType, OpType opType, Object msg) {
		return sendMessage(msgType, opType, msg, null);
	}
	
	
	
	public <T> boolean sendMessage(MsgType msgType, OpType opType, T msg, MessageHandler<T> handler) {
		BinaryUtils.checkEmpty(msgType, "msgType");
		BinaryUtils.checkEmpty(opType, "opType");
		BinaryUtils.checkEmpty(msg, "msg");
		
		Object obj = msg;
		if(handler != null) {
			obj = handler.correctMessage(opType, msg);
			if(obj == null) throw new ServiceException(" the correct message result is NULL! ");
		}
		
		MsgEntity entity = new MsgEntity();
		entity.setType(msgType.name());
		entity.setOpt(opType.name());
		entity.setTime(System.currentTimeMillis());
		entity.setMsg(obj);
		
		try {
			return sendMsg(entity);
		}catch(Throwable t) {
			logger.error(" send mssage '"+JSON.toString(msg)+"' error! ", t);
			return false;
		}
	}
	
	
	
	
	
	/**
	 * 向消息队列中发送消息
	 * @param msg
	 * @return
	 * @throws Throwable
	 */
	protected abstract boolean sendMsg(MsgEntity msg) throws Throwable ;
	
	
	

}

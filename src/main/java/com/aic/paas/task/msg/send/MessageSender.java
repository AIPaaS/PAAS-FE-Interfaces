package com.aic.paas.task.msg.send;

import com.aic.paas.task.msg.send.msg.MsgType;
import com.binary.framework.bean.EntityBean;

public interface MessageSender {
	
	
	
	
	/**
	 * 发送实例bean对象, 系统会自动识别bean数据的OpType
	 * @param msgType 指定消息类型
	 * @param msg 指定发送对象
	 */
	public <T extends EntityBean> boolean sendMessage(MsgType msgType, T msg);
	
	
	
	
	
	/**
	 * 发送消息对象
	 * @param msgType 指定消息类型
	 * @param opType 操作类型
	 * @param msg 指定发送对象
	 * @return
	 */
	public boolean sendMessage(MsgType msgType, OpType opType, Object msg);
	
	
	
	
	/**
	 * 发送消息对象
	 * @param msgType 指定消息类型
	 * @param opType 操作类型
	 * @param msg 指定发送对象
	 * @param 消息转换对象
	 * @return
	 */
	public <T extends EntityBean> boolean sendMessage(MsgType msgType, T msg, MessageHandler<T> handler);
	
	
	
	
	/**
	 * 发送消息对象
	 * @param msgType 指定消息类型
	 * @param opType 操作类型
	 * @param msg 指定发送对象
	 * @param 消息转换对象
	 * @return
	 */
	public <T> boolean sendMessage(MsgType msgType, OpType opType, T msg, MessageHandler<T> handler);
	
	
	
	
	

}

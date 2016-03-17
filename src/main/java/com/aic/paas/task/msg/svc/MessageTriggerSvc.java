package com.aic.paas.task.msg.svc;

import com.aic.paas.task.msg.send.msg.MsgType;


/**
 * 消息处发器
 * @author wanwb
 */
public interface MessageTriggerSvc {
	
	
	
	/**
	 * 指定ID触发消息
	 * @param type 对应消息代码
	 * @param ids ID列表
	 */
	public void sendMessageByIds(MsgType msgType, Long[] ids);
	
	

	
	
	/**
	 * 指定日期触发消息
	 * @param type 对应消息代码
	 * @param date 格式：yyyyMMdd
	 */
	public void sendMessageByDate(MsgType msgType, Integer date);
	

	
	
	
	/**
	 * 指定时间区间触发消息
	 * @param type 对应消息代码
	 * @param startTime 起始时间, yyyyMMddHHmmss
	 * @param endTime 截止时间，yyyyMMddHHmmss
	 */
	public void sendMessageByTimeInterval(MsgType msgType, Long startTime, Long endTime);
	
	

	
	
	/**
	 * 触发发送所有消息
	 * @param type 对应消息代码
	 */
	public void sendAllMessage(MsgType msgType);
	
	
	
	
	
	
}

package com.aic.paas.task.msg.receive;

public interface NsqReceiveHandler {
	
	
	
	/**
	 * 获取消息监听topic名称
	 * @return
	 */
	public String getTopicName();
	
	
	
	
	/**
	 * 获取消息监听channel名称
	 * @return
	 */
	public String getChannelName();
	
	
	
	
	
	/**
	 * 消息接收事件
	 * @param msg
	 */
	public void receive(String msg);
	
	
	
	

}

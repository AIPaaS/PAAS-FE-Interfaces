package com.aic.paas.task.msg.send;

public interface MessageHandler<E> {

	
	
	
	
	/**
	 * 修正Msg,将参数Msg转换为消息队列实际所需格式
	 * @param opType 操作类型
	 * @param msg
	 * @return
	 */
	public Object correctMessage(OpType opType, E msg);
	
	
	
	
}

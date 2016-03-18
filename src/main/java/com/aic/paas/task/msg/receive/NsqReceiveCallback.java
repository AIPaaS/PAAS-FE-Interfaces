package com.aic.paas.task.msg.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binary.core.util.BinaryUtils;
import com.binary.framework.Local;
import com.binary.framework.bean.User;
import com.binary.framework.exception.ServiceException;
import com.github.brainlag.nsq.NSQMessage;
import com.github.brainlag.nsq.callbacks.NSQMessageCallback;

public class NsqReceiveCallback implements NSQMessageCallback {
	private static final Logger logger = LoggerFactory.getLogger(NsqReceiveCallback.class);
	
	
	private NsqReceiveHandler handler;
	private String charset;
	
	
	
	
	public NsqReceiveCallback(NsqReceiveHandler handler, String charset) {
		BinaryUtils.checkEmpty(handler, "handler");
		this.charset = charset;
		if(BinaryUtils.isEmpty(this.charset)) {
			this.charset = "UTF-8";
		}
	}
	
	
	
	private String getHandlerName() {
		return this.handler.getTopicName() + " - " + this.handler.getChannelName();
	}
	
	
	
	@Override
	public void message(NSQMessage msg) {
		String handlerName = getHandlerName();
		
		try {
			try {
				Local.open((User)null);
				byte[] bs = msg.getMessage();
				if(bs==null || bs.length==0) {
					throw new ServiceException(" ["+handlerName+"] received message is empty! ");
				}
				
				String s = new String(bs, this.charset);
				logger.info(" ["+handlerName+"] received message: "+s);
				this.handler.receive(s);
				Local.commit();
			}catch(Throwable t) {
				Local.rollback();
				throw t;
			}finally {
				Local.close();
			}
		}catch(Throwable t) {
			logger.error(" ["+handlerName+"] process message error! ", t);
		}
	}

	
	
	
	
}

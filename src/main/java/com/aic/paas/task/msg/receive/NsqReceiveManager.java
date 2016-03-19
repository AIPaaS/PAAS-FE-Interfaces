package com.aic.paas.task.msg.receive;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

public class NsqReceiveManager implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(NsqReceiveManager.class);
	
	
	private final Runnable runnable = new Runnable() {
		public void run() {
			runEntity();
		}
	};
	
	
	private final Object syncobj = new Object();
	private boolean started = false;
	
	
	/** 是否开起接收数据 **/
	private Boolean open = true;
	
	/** NSQ服务主机IP **/
	private String nsqHost;
	
	/** NSQ服务主机端口 **/
	private Integer nsqPort;
	
	/** 传输数据字符集 **/
	private String charset;
	
	
	private NsqReceiveHandler[] receiveHandlers;
	private final List<NsqReceiveCallback> receiveCallbacks = new ArrayList<NsqReceiveCallback>();
	
		
	
	public String getNsqHost() {
		return nsqHost;
	}
	public void setNsqHost(String nsqHost) {
		this.nsqHost = nsqHost;
	}
	public Integer getNsqPort() {
		return nsqPort;
	}
	public void setNsqPort(Integer nsqPort) {
		this.nsqPort = nsqPort;
	}
	public NsqReceiveHandler[] getReceiveHandlers() {
		return receiveHandlers;
	}
	public void setReceiveHandlers(NsqReceiveHandler[] receiveHandlers) {
		BinaryUtils.checkEmpty(receiveHandlers, "receiveHandlers");
		this.receiveHandlers = receiveHandlers;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
	
	
	
	private void runEntity() {
		try {
			logger.info(" NsqReceiveManager  is initializing ... ");
			if(BinaryUtils.isEmpty(this.nsqHost)) {
				throw new ServiceException(" not set property 'nsqHost'! ");
			}
			if(BinaryUtils.isEmpty(this.nsqPort)) {
				throw new ServiceException(" not set property 'nsqPort'! ");
			}
			if(BinaryUtils.isEmpty(this.receiveHandlers)) {
				throw new ServiceException(" not set property 'receiveHandlers'! ");
			}
			
			NSQLookup lookup = new DefaultNSQLookup();
			lookup.addLookupAddress(this.nsqHost, this.nsqPort);
			
			for(int i=0; i<this.receiveHandlers.length; i++) {
				NsqReceiveHandler handler = this.receiveHandlers[i];
				NsqReceiveCallback cb = new NsqReceiveCallback(handler, this.charset);
				receiveCallbacks.add(cb);
				NSQConsumer consumer = new NSQConsumer(lookup, handler.getTopicName(), handler.getChannelName(), cb);
				consumer.start();
			}
		}catch(Throwable t) {
			logger.error(" initialization NsqReceiveManager error! ", t);
		}
	}




	@Override
	public void afterPropertiesSet() throws Exception {
		
		if(Boolean.TRUE.equals(this.open)) {
			try {
				logger.info(" start initialization NsqReceiveManager ... ");
				
				synchronized (syncobj) {
					if(this.started) {
						logger.warn(" NsqReceiveManager is started! ");
						return ;
					}
					
					Thread thread = new Thread(runnable);
					thread.setDaemon(true);
					thread.start();
					this.started = true;
				}
			}catch(Throwable t) {
				logger.error(" initialization NsqReceiveManager error! ", t);
			}
		}
		
	}
	

}

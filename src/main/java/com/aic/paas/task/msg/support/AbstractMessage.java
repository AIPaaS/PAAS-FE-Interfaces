package com.aic.paas.task.msg.support;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.sys.BsSyncdataConfig;
import com.aic.paas.task.bean.sys.CBsSyncdataConfig;
import com.aic.paas.task.msg.Message;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.rest.sys.BsSyncdataConfigSvc;
import com.aic.paas.task.send.MessageHandler;
import com.aic.paas.task.send.MessageSender;
import com.aic.paas.task.send.OpType;
import com.binary.core.bean.BMProxy;
import com.binary.framework.Local;
import com.binary.framework.bean.Condition;
import com.binary.framework.bean.EntityBean;
import com.binary.framework.exception.ServiceException;

public abstract class AbstractMessage<E extends EntityBean, F extends Condition> implements Message<E,F>, MessageHandler<E> {
	private static Logger logger = LoggerFactory.getLogger(AbstractMessage.class);
	
	
	
	@Autowired
	BsSyncdataConfigSvc syncSvc;
	
	
	private MessageSender messageSender;
	
	/** 批量发送消息大小 **/
	private int pageSize = 100;
	
	
	
	public MessageSender getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize < 1) throw new ServiceException(" is wrong pageSize '"+pageSize+"'! ");
		this.pageSize = pageSize;
	}
	
	
	
	

	protected BsSyncdataConfig getSyncdataConfig() {
		MsgType type = getType();
		
		CBsSyncdataConfig cdt = new CBsSyncdataConfig();
		cdt.setMsgCode(type.name());
		cdt.setDataStatus(1);
		List<BsSyncdataConfig> ls = syncSvc.queryList(cdt, null);
		
		if(ls==null || ls.size()==0) {
			throw new ServiceException(" not found SyncdataConfig by MsgType '"+type+"'! ");
		}
		
		return ls.get(0);
	}
	
	
	protected void updateSyncdataTime(Long configId, Long syncTime) {
		BsSyncdataConfig upcfg = new BsSyncdataConfig();
		upcfg.setId(configId);
		upcfg.setSyncTime(syncTime);
		syncSvc.saveOrUpdate(upcfg);
	}
	
	
	
	@Override
	public final Object correctMessage(OpType opType, E msg) {
		return doCorrectMessage(opType, msg);
	}
	
	
	
	/**
	 * 修正Msg,将参数Msg转换为消息队列实际所需格式
	 * 如果字类想修改可重写此方法
	 * @param opType
	 * @param msg
	 * @return
	 */
	protected Object doCorrectMessage(OpType opType, E msg) {
		return msg;
	}
	
	


	@Override
	public void sendMssageBySync() {
		MsgType msgType = getType();
		logger.info("---------------sendMssageBySync ["+msgType+"] ----------------");
		
		BsSyncdataConfig cfg = getSyncdataConfig();
		Long syncTime = cfg.getSyncTime();
		if(syncTime == null) {
			syncTime = 0l;
		}else {
			syncTime += 1;
		}
		
		
		BMProxy<F> cdtproxy = BMProxy.getInstance(getConditionClass());
		F cdt = cdtproxy.newInstance();
		
		Long lastId = 0l;
		long count = 0;
		long real = 0;
		boolean firstQuery = true;
		
		while(true) {
			cdtproxy.set("startModifyTime", syncTime);
			cdtproxy.set("startId", lastId);
			
			List<E> ls = queryList(1, this.pageSize, cdt, " MODIFY_TIME, ID ");
			count += firstQuery ? ls.size() : ls.size()-1;
			
			E lastMsg = null;
			
			if(ls.size() > 0) {
				for(int i=firstQuery?0:1; i<ls.size(); i++) {
					E msg = ls.get(i);
					
					//发送消息
					boolean ba = this.messageSender.sendMessage(msgType, msg, this);
					if(ba) real ++ ;
					
					lastMsg = msg;
				}
				
				updateSyncdataTime(cfg.getId(), lastMsg.getModifyTime());
				Local.commit();
			}
			
			if(ls.size() < this.pageSize) break;
			
			firstQuery = false;
			lastId = lastMsg.getId();
			syncTime = lastMsg.getModifyTime();
		}
		
		logger.info("[sendMssageBySync]消息["+msgType.name()+"]发送总数["+count+"]个, 成功["+real+"]个, 失败["+(count-real)+"]个.");
	}
	
	
	
	
	@Override
	public void sendMessageByCdt(F cdt) {
		MsgType msgType = getType();
		
		BMProxy<F> cdtproxy = BMProxy.getInstance(getConditionClass());
		if(cdt == null) {
			cdt = cdtproxy.newInstance();
		}else {
			cdtproxy.replaceInnerObject(cdt);
		}
		
		Long lastId = 0l;
		long count = 0;
		long real = 0;
		
		while(true) {
			cdtproxy.set("startId", lastId);
			
			List<E> ls = queryList(1, this.pageSize, cdt, " ID ");
			count += ls.size();
			
			E lastMsg = null;
			
			if(ls.size() > 0) {
				for(int i=0; i<ls.size(); i++) {
					E msg = ls.get(i);
					
					//发送消息
					boolean ba = this.messageSender.sendMessage(msgType, msg, this);
					if(ba) real ++ ;
					
					lastMsg = msg;
				}
			}
			
			if(ls.size() < this.pageSize) break;
			
			lastId = lastMsg.getId()+1;
		}
		
		
		logger.info("[sendMessageByCdt]消息["+msgType.name()+"]发送总数["+count+"]个, 成功["+real+"]个, 失败["+(count-real)+"]个.");
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.aic.paas.task.msg.send.msg;

import java.util.HashMap;
import java.util.Map;

import com.binary.core.util.BinaryUtils;
import com.binary.framework.bean.Condition;
import com.binary.framework.bean.EntityBean;
import com.binary.framework.exception.ServiceException;

public class MessageFactory {
	
	
	private final Map<MsgType, Message<?,?>> messageStore = new HashMap<MsgType, Message<?,?>>();
	
		
	
	
	
	public void setMessages(Message<?,?>[] messages) {
		BinaryUtils.checkEmpty(messages, "messages");
		
		for(int i=0; i<messages.length; i++) {
			Message<?,?> m = messages[i];
			if(messageStore.containsKey(m.getType())) {
				throw new ServiceException(" exists message-code '"+m.getType()+"'! ");
			}
			messageStore.put(m.getType(), m);
		}
	}
	
	
	/**
	 * 根据消息类型获取消息对象
	 * @param msgType
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E extends EntityBean, F extends Condition> Message<E,F> getMessage(MsgType msgType) {
		BinaryUtils.checkEmpty(msgType, "msgType");
//		Message<?,?> msg = null;
//		
//		switch (msgType) {
//			case DC: msg = springContext.getBean(PcDataCenterMsg.class); break;		//数据中心
//			case RC: msg = springContext.getBean(PcResCenterMsg.class); break;		//资源中心
//			case NC: msg = springContext.getBean(PcNetZoneMsg.class); break;		//网络区域
//			case USER: msg = springContext.getBean(SysOpMsg.class); break;		//用户信息
//			case APP: msg = springContext.getBean(PcAppMsg.class); break;		//应用信息
//			case CONT: msg = springContext.getBean(PcAppImageMsg.class); break;		//容器信息
//			case CONT_INST: msg = springContext.getBean(PcAppDepInstanceMsg.class); break;		//容器实例信息
//			case USER_APP: msg = springContext.getBean(PcAppMgrMsg.class); break;		//用户+应用关系
//			default: throw new ServiceException(" is wrong msgType '"+msgType+"'! ");
//		}
		Message<?,?> msg = messageStore.get(msgType);
		if(msg == null) throw new ServiceException(" is wrong msgType '"+msgType+"'! ");
		
		return (Message)msg;
	}

	
	
	
	
	/**
	 * 获取所有消息对象
	 * @return
	 */
	public <E extends EntityBean, F extends Condition> Map<MsgType, Message<E,F>> getAllMessage() {
		MsgType[] types = MsgType.values();
		Map<MsgType, Message<E,F>> map = new HashMap<MsgType, Message<E,F>>();
		
		for(int i=0; i<types.length; i++) {
			Message<E,F> msg = getMessage(types[i]);
			map.put(types[i], msg);
		}
		
		return map;
	}


	
	
	
	
}

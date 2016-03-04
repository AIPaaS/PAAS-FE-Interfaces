package com.aic.paas.task.send;

import java.io.Serializable;

public class MsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	/** 消息类型 **/
	private String type;
	
	/** 操用类型 **/
	private String opt;
	
	/** 时间毫秒数 **/
	private Long time;
	
	/** 消息对象 **/
	private Object msg;
	
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
	
	
	
	
	


}

package com.aic.paas.task.bean.dep;

import com.binary.framework.bean.EntityBean;

public class AppMgr implements EntityBean {
	private static final long serialVersionUID = 1L;
	
	
	
	private Long userId;
	private Long[] appIds;
	
	private Long createTime;
	private Long modifyTime;
	
	
	
	
	@Override
	public Long getId() {
		return userId;
	}
	@Override
	public void setId(Long id) {
		this.userId = id;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long[] getAppIds() {
		return appIds;
	}
	public void setAppIds(Long[] appIds) {
		this.appIds = appIds;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	
	

	
	
	
	
	

}

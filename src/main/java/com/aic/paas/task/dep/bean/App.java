package com.aic.paas.task.dep.bean;


public class App extends PcApp {
	private static final long serialVersionUID = 1L;
	
	/** 
	 * 配置状态	0=未完成 1=已完成 
	 * */
	private Integer setupStatus ;

	public Integer getSetupStatus() {
		return setupStatus;
	}

	public void setSetupStatus(Integer setupStatus) {
		this.setupStatus = setupStatus;
	}

	
	
	
	

}

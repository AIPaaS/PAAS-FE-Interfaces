package com.aic.paas.task.mvc.dev.bean.base;

public class BaseResponse {
	
	private String namespace;
	private String repo_name;
	private String mnt_id;
	
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getRepo_name() {
		return repo_name;
	}
	public void setRepo_name(String repo_name) {
		this.repo_name = repo_name;
	}
	public String getMnt_id() {
		return mnt_id;
	}
	public void setMnt_id(String mnt_id) {
		this.mnt_id = mnt_id;
	}
	
}

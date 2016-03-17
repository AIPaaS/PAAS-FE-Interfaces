package com.aic.paas.task.dev.bean;

public class PcBuildResponse {
	
	private String namespace;
	private String repo_name;
	private String status;
	private String build_id;

	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuild_id() {
		return build_id;
	}
	public void setBuild_id(String build_id) {
		this.build_id = build_id;
	}
	
}

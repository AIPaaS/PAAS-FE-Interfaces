package com.aic.paas.task.mvc.dev.bean;

import com.aic.paas.task.mvc.dev.bean.base.BaseResponse;

public class PcBuildTaskResponse extends BaseResponse {

	// 构建ID号
	private String build_id;

	// 任务启动的时间
	private String created_at;

	// started,error, queue,
	private String status;


	public String getBuild_id() {
		return build_id;
	}

	public void setBuild_id(String build_id) {
		this.build_id = build_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

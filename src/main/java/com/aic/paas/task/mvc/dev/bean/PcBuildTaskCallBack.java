package com.aic.paas.task.mvc.dev.bean;

import com.aic.paas.task.mvc.dev.bean.base.BaseResponse;

public class PcBuildTaskCallBack extends BaseResponse {
	
	private String tag;

	// 构建ID号
	private String build_id;

	// //持续时间(毫秒)
	private String duration;

	// 任务结束的时间
	private String time;

	// started,error
	private String status;


	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBuild_id() {
		return build_id;
	}

	public void setBuild_id(String build_id) {
		this.build_id = build_id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
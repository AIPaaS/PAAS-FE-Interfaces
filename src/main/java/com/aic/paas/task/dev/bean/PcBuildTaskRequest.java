package com.aic.paas.task.dev.bean;

import com.aic.paas.task.dev.bean.base.BaseRequest;

public class PcBuildTaskRequest extends BaseRequest {
	// image_name镜像名（对应目录 + 镜像名+ 版本号）	
	private String image_name;
	
	// tag 指定构建的目标版本	
	private String tag;
	
	// http://xxxxxx/build 回调地址	
	private String callback_url;

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

}

package com.aic.paas.task.dev.bean;

import com.aic.paas.task.dev.bean.base.BaseRequest;
import com.aic.paas.task.dev.bean.base.BaseResponse;

public class DemoRequest extends BaseRequest {
	
	private String image_name;
	private String opt;   //start启动， stop 停止
	private String tag; 
	private String callback_url; //http://xxxxxx/build /启动时提供 ，停止不需要
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
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

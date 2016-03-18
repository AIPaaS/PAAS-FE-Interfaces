package com.aic.paas.task.dev.peer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dev.peer.PcImagePeer;
import com.aic.paas.task.dev.rest.PcImageSvc;
import com.aic.paas.task.util.http.HttpClientUtil;

public class PcImagePeerImpl implements PcImagePeer {

	static final Logger logger = LoggerFactory.getLogger(PcImagePeerImpl.class);
	
	@Autowired
	PcImageSvc imageSvc;

	private String buildManagementUrl;

	public void setBuildManagementUrl(String buildManagementUrl) {
		if (buildManagementUrl != null) {
			this.buildManagementUrl = buildManagementUrl.trim();
		}
	}

	@Override
	public String uploadImage(String param) {
		String result = "";
		try {
			result =HttpClientUtil.sendPostRequest(buildManagementUrl+" /v1/image", param); 
		} catch (Exception e) {
			logger.error("上传镜像，调用远程服务失败！");
		}
		return result;
	}

	@Override
	public String updateImageByCallBack(String param) {
		
		return imageSvc.updateImageByCallBack(param);
	}

}

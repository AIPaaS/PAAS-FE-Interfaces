package com.aic.paas.task.dev.peer.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dev.peer.PcImagePeer;
import com.aic.paas.task.dev.rest.PcImageSvc;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;

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
	@SuppressWarnings("unchecked")
	@Override
	public String imageSyncApi(String param) {
		String result = HttpClientUtil.sendPostRequest(buildManagementUrl+"/v1/imagesync", param);
		if(result!=null&&!"".equals(result)){
			Map<String,String> map = JSON.toObject(result, Map.class);
			return map.get("status");
		}else{
			return "error";
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public String imageSyncCallback(String param) {
		Map<String,String> paramMap =null;
		if(param!=null&&!"".equals(param)){
			paramMap = JSON.toObject(param,Map.class);
			if(paramMap.get("image_name")==null || "".equals(paramMap.get("image_name").trim())){
				return "error";
			}
			if(paramMap.get("tag")==null || "".equals(paramMap.get("tag").trim())){
				return "error";
			}
			if(paramMap.get("sync_cloud_id")==null || "".equals(paramMap.get("sync_cloud_id").trim())){
				return "error";
			}
			if(paramMap.get("status")==null || "".equals(paramMap.get("status").trim())){
				return "error";
			}
		}else{
			return "error";
		}
		return imageSvc.imageSyncCallback(param.trim());
	}

}

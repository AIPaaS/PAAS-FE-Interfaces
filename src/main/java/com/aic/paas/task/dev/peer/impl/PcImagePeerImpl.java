package com.aic.paas.task.dev.peer.impl;

import java.util.HashMap;
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
	private String wdevUrl;
	public void setWdevUrl(String wdevUrl) {
		if (wdevUrl != null) {
			this.wdevUrl = wdevUrl.trim();
		}
	}	
	@Override
	public String uploadImage(String param) {
		String result = "";
		try {
			result =HttpClientUtil.sendPostRequest(buildManagementUrl+"/v1/image", param); 
		} catch (Exception e) {
			logger.error("上传镜像，调用远程服务失败！");
		}
		return result;
	}

	@Override
	public String updateImageByCallBack(String param) {
		String result = "error";
		if("".equals(param)){
			logger.error("上传镜像时，回调函数中传入参数为空！");
			return result ;
		}
		Map<String,String> updateMap = new HashMap<String,String>();
		
		//请求dev的前场，目的是获取：镜像库Id----------------------------------------------------
		String imgRespId = HttpClientUtil.sendPostRequest(wdevUrl+"/dev/image/saveImageByCallBack",param); 
		if("error".equals(imgRespId)){
			logger.info("查询出的镜像库的Id为error");
			return result;
		}
		updateMap = JSON.toObject(param,Map.class);
		if("isExt".equals(imgRespId)){
			logger.info("是外部镜像，没有对应的产品，工程，镜像库。此时默认imgRespId为000000");
			updateMap.put("imgRespId", "000000");
		}else{
			updateMap.put("imgRespId", imgRespId);
		}
				
		String updateParam = JSON.toString(updateMap);
		result = imageSvc.updateImageByCallBack(updateMap);
		if("success".equals(result)){
			String export_file_url = updateMap.get("export_file_url");
			String[] array = export_file_url.split("/");
			String filename = "";
			if(array.length>0){
				filename = array[array.length-1];
			}
			if(!"".equals(filename)){
				logger.info("调用dev中删除镜像的地址是："+wdevUrl+"/dev/image/deleteImage/"+filename);
				String sendResult = HttpClientUtil.sendPostRequest(wdevUrl+"/dev/image/deleteImage/"+filename,"");
				Map<String,String> sendResultMap = new HashMap<String,String>();
				logger.info("调用dev中删除镜像的返回值sendResult是："+sendResult);
				if(!"".equals(sendResult)){
					sendResultMap = JSON.toObject(sendResult,Map.class);
					result = sendResultMap.get("result");
				}
				logger.info("删除镜像的结果是："+result);
				
			}
		}
		return result;
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

package com.aic.paas.task.peer.dev.impl;



import java.util.Map;

import com.aic.paas.task.peer.dev.PcBuildDefPeer;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;

public class PcBuildDefPeerImpl implements PcBuildDefPeer {
	
	private String buildManagementUrl;

	public void setBuildManagementUrl(String buildManagementUrl) {
		this.buildManagementUrl = buildManagementUrl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String buildDefApi(String param) {
		String result = HttpClientUtil.sendPostRequest(buildManagementUrl+"/v1/repositories", param);
		if(result!=null&&!"".equals(result)){
			Map<String,String> map = JSON.toObject(result, Map.class);
			return map.get("status");
		}else{
			return "error";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String updateBuildDefApi(String param) {
		String result = HttpClientUtil.sendPutRequest(buildManagementUrl+"/v1/repositories", param);
		if(result!=null&&!"".equals(result)){
			Map<String,String> map = JSON.toObject(result, Map.class);
			return map.get("status");
		}else{
			return "error";
		}
	}

	
	

}

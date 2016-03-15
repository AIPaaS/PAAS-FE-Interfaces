package com.aic.paas.task.peer.dev.impl;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.mvc.dev.bean.PcBuildResponse;
import com.aic.paas.task.peer.dev.PcBuildTaskPeer;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;

public class PcBuildTaskPeerImpl implements PcBuildTaskPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskPeerImpl.class);
	
	private String buildManagementUrl;
	public void setBuildManagementUrl(String buildManagementUrl) {
		if(buildManagementUrl != null) {
			this.buildManagementUrl = buildManagementUrl.trim();
		}
	}

	//@Autowired
	//PcAppImageSvc appImageSvc;

	

	@Override
	public String stopPcBuildTaskApi(String params) {
		
		String url = buildManagementUrl+"/v1/repositories";
		String  param ="";
		try {
			param = java.net.URLEncoder.encode(params,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}   
		/*String rpc = HttpClientUtil.sendDeleteRequest(url, param);//build_id=123456&namespace=SSS&repo_name=test2
		PcBuildResponse buildRes = JSON.toObject(rpc, PcBuildResponse.class);
		return buildRes.getStatus();*/
		return "aborted";
	}

	

}

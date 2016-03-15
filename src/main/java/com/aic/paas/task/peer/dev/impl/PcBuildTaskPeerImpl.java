package com.aic.paas.task.peer.dev.impl;

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
	public String stopPcBuildTaskApi(String param) {
		
		String url = buildManagementUrl+"/v1/repositories";
		String rpc = HttpClientUtil.sendDeleteRequest(url, param);
		PcBuildResponse buildRes = JSON.toObject(rpc, PcBuildResponse.class);
		return buildRes.getStatus();
	}

	

}

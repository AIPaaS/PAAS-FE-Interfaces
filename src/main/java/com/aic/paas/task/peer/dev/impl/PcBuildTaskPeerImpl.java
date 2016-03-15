package com.aic.paas.task.peer.dev.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.peer.dev.PcBuildTaskPeer;

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
		// TODO Auto-generated method stub
		return null;
	}

	

}

package com.aic.paas.task.peer.dev.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.peer.dev.PcBuildPeer;

public class PcBuildPeerImpl implements PcBuildPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildPeerImpl.class);

	private String buildManagementUrl;
	public void setBuildManagementUrl(String buildManagementUrl) {
		if(buildManagementUrl != null) {
			this.buildManagementUrl = buildManagementUrl.trim();
		}
	}
	
	//@Autowired
	//PcAppImageSvc appImageSvc;

	
	@Override
	public String removePcBuildApi(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

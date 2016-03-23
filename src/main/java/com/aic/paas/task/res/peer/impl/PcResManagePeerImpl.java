package com.aic.paas.task.res.peer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.res.peer.PcResManagePeer;
import com.aic.paas.task.res.rest.IResCenterServiceManager;

public class PcResManagePeerImpl implements PcResManagePeer {
	static final Logger logger = LoggerFactory.getLogger(PcResManagePeerImpl.class);

	@Autowired
	IResCenterServiceManager iResCenterServiceManager;

	@Override
	public String queryLog(Long clusterId) {
		return iResCenterServiceManager.queryLog(clusterId+"");
	}
}

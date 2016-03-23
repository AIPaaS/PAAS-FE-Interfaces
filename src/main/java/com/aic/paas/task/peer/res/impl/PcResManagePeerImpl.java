package com.aic.paas.task.peer.res.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.peer.res.PcResManagePeer;
import com.aic.paas.task.rest.res.IResCenterServiceManager;

public class PcResManagePeerImpl implements PcResManagePeer {
	static final Logger logger = LoggerFactory.getLogger(PcResManagePeerImpl.class);

	@Autowired
	IResCenterServiceManager iResCenterServiceManager;

	@Override
	public String queryLog(Long clusterId) {
		return iResCenterServiceManager.queryLog(clusterId+"");
	}
}

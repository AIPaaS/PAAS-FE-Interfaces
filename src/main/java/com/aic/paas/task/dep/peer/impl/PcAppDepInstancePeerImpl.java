package com.aic.paas.task.dep.peer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.PcAppDepInstance;
import com.aic.paas.task.dep.peer.PcAppDepInstancePeer;
import com.aic.paas.task.dep.rest.PcAppDepInstanceSvc;

public class PcAppDepInstancePeerImpl implements PcAppDepInstancePeer {

	
	@Autowired
	PcAppDepInstanceSvc depInstanceSvc;
	
	
	
	@Override
	public Long saveOrUpdate(PcAppDepInstance record) {
		return depInstanceSvc.saveOrUpdate(record);
	}
	
	

	@Override
	public Long addDepInstanceByAppImgFullName(String appImgFullName, PcAppDepInstance record) {
		return depInstanceSvc.addDepInstanceByAppImgFullName(appImgFullName, record);
	}
	

	@Override
	public Integer disableDepInstanceByInstanceName(String instanceName) {
		return depInstanceSvc.disableDepInstanceByInstanceName(instanceName);
	}
	
	
	

}

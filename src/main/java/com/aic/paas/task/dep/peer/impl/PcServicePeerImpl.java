package com.aic.paas.task.dep.peer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.ExternalServiceReq;
import com.aic.paas.task.dep.bean.ExternalServiceReq.Check;
import com.aic.paas.task.dep.bean.PcService;
import com.aic.paas.task.dep.peer.PcServicePeer;
import com.aic.paas.task.dep.rest.IExternalServiceManager;
import com.aic.paas.task.dep.rest.PcServiceSvc;
import com.binary.json.JSON;

public class PcServicePeerImpl implements PcServicePeer{

	@Autowired
	IExternalServiceManager iExternalServiceManager;
	@Autowired
	PcServiceSvc pcServiceSvc;
	
	@Override
	public String register(String record) {
		PcService service = JSON.toObject(record, PcService.class);
		return registerToConsul(service);
	}

	@Override
	public String deregister(String record) {
		PcService service = JSON.toObject(record, PcService.class);
		return deleteSrvFromConsul(pcServiceSvc.queryById(service.getId()));
	}
	
	/**
	 * 调用辅助后场 将服务注册到consul
	 * @param record
	 */
	private String registerToConsul(PcService record) {
		
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId(record.getResCenterId().toString());
		externalServiceReq.setServiceId(record.getSvcCode());
		externalServiceReq.setServiceName(record.getSvcName());
		externalServiceReq.setAddress(record.getIp());
		externalServiceReq.setPort(record.getPort());
		
		List<Check> checks = new ArrayList<Check>();
		Check check = new Check();
		check.setScript(record.getCustom4());
		check.setInterval("30s");
		check.setTtl("60s");
		checks.add(check);
		externalServiceReq.setCheck(checks);
		
		return iExternalServiceManager.add(JSON.toString(externalServiceReq));
	}
	
	/**
	 * 删除已注册到consul的服务
	 * @param record
	 */
	private String deleteSrvFromConsul(PcService record) {
		if(record==null)
			return "";
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId(record.getResCenterId().toString());
		externalServiceReq.setServiceId(record.getSvcCode());
		return iExternalServiceManager.delete(JSON.toString(externalServiceReq));
	}

}

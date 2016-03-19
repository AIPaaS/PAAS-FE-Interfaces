package com.aic.paas.task.dep.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.AppAccessCodeUrl;
import com.aic.paas.task.dep.bean.AppAccessModel;
import com.aic.paas.task.dep.bean.CPcAppAccess;
import com.aic.paas.task.dep.bean.CPcAppImage;
import com.aic.paas.task.dep.bean.ParmDockerImage;
import com.aic.paas.task.dep.bean.PcAppAccess;
import com.aic.paas.task.dep.bean.PcAppImage;
import com.aic.paas.task.dep.bean.PcResCenter;
import com.aic.paas.task.dep.peer.PcAppAccessPeer;
import com.aic.paas.task.dep.rest.IAppAccessManager;
import com.aic.paas.task.dep.rest.PcAppAccessSvc;
import com.aic.paas.task.dep.rest.PcAppImageSvc;
import com.aic.paas.task.dep.rest.PcResCenterSvc;
import com.alibaba.dubbo.common.json.ParseException;
import com.binary.framework.exception.ServiceException;
import com.binary.json.JSON;

public class PcAppAccessPeerImpl implements PcAppAccessPeer {
	@Autowired
	PcAppAccessSvc appAccessSvc;
	
	@Autowired
	IAppAccessManager appAccessManager;
	
	@Autowired
	PcAppImageSvc appImageSvc;
	
	@Autowired
	PcResCenterSvc resCenterSvc;
	
	@Override
	public String saveOrUpdate(String record) {
		PcAppAccess service = JSON.toObject(record, PcAppAccess.class);
		
		AppAccessModel param = new AppAccessModel();
		PcAppImage pai = appImageSvc.queryById(service.getAppImageId());
		if(pai!=null)
			param.setContainer(pai.getContainerFullName());
		param.setAccessCode(service.getAccessCode());
		param.setAccessCodeOld(service.getAccessCode());
		PcResCenter resCenter = resCenterSvc.queryById(service.getResCenterId());
		if(pai!=null&&resCenter!=null)
//			param.setDns("_"+param.getContainer()+".marathon."+resCenter.getDomain());
			param.setDns("_"+param.getContainer()+"._tcp.marathon.ai");
		param.setProtocol(service.getProtocol());
//		param.setResCenterId(service.getResCenterId().toString());
		param.setResCenterId("dev");
		//获取后场返回值 
		String result = null;
		PcAppAccess old = appAccessSvc.queryById(service.getId());
		if(service.getId()==null){
			result = appAccessManager.add(JSON.toString(param));
		}else{
			if(old==null)
				old = appAccessSvc.queryById(service.getId());
			param.setAccessCodeOld(old.getAccessCode());
			result = appAccessManager.modify(JSON.toString(param));
		}
		AppAccessCodeUrl aacu = JSON.toObject(result, AppAccessCodeUrl.class);
		if("000000".equals(aacu.getCode())){
			PcAppAccess paa = new PcAppAccess();
			paa.setId(service.getId());
			paa.setAccessUrl(aacu.getAccessUrl());
			appAccessSvc.saveOrUpdate(paa);
		}else{
			throw new ServiceException(" modify remote cfg error ! "); 
		}
		
		return result;
	}

	@Override
	public String remove(String record) {
		PcAppAccess service = JSON.toObject(record, PcAppAccess.class);
		PcAppAccess access = appAccessSvc.queryById(service.getId());
		//获取后场返回值 
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";
		PcAppImage appImage = appImageSvc.queryById(access.getAppImageId());
		String fullName = appImage.getContainerFullName();
		AppAccessModel appAccessModel = new AppAccessModel();
		appAccessModel.setContainer(fullName);
//		String dns = "_"+fullName+"._tcp.marathon."+resCenterSvc.queryById(access.getResCenterId()).getDomain();
		String dns = "_"+fullName+"._tcp.marathon.ai";
		appAccessModel.setDns(dns);
		appAccessModel.setProtocol(access.getProtocol());
		appAccessModel.setAccessCode(access.getAccessCode());
		appAccessModel.setAccessCodeOld(access.getAccessCode());
//		String resCenterId = access.getResCenterId().toString();
		String resCenterId="dev";
		appAccessModel.setResCenterId(resCenterId);
		result = appAccessManager.delete(JSON.toString(appAccessModel));
		return result;
	}

	@Override
	public String asynsaveOrUpdate(ParmDockerImage param) {
		AppAccessModel appAccessModel = new AppAccessModel();
		String fullName = param.getDockerImage();
		CPcAppImage cpcAppImage = new CPcAppImage();
		cpcAppImage.setContainerFullName(fullName);
		List<PcAppImage> list = appImageSvc.queryList(cpcAppImage, "ID desc");
		if(list==null || list.size() == 0 ){
		}else{
			PcAppImage appImage = list.get(0);
			CPcAppAccess cdt = new CPcAppAccess();
			cdt.setAppId(appImage.getAppId());
			cdt.setAppImageId(appImage.getId());
			List<PcAppAccess> ls = appAccessSvc.queryList(cdt, null);
			if(ls!=null && ls.size()>0){
				PcAppAccess appAccess = ls.get(0);
				if(appImage!=null)
					appAccessModel.setContainer(appImage.getContainerFullName());
				appAccessModel.setAccessCode(appAccess.getAccessCode());
				appAccessModel.setAccessCodeOld(appAccess.getAccessCode());
				PcResCenter resCenter = resCenterSvc.queryById(appAccess.getResCenterId());
				if(appImage!=null&&resCenter!=null)
//					appAccessModel.setDns("_"+appAccessModel.getContainer()+".marathon."+resCenter.getDomain());
					appAccessModel.setDns("_"+appAccessModel.getContainer()+"._tcp.marathon.ai");
				appAccessModel.setProtocol(appAccess.getProtocol());
//				appAccessModel.setResCenterId(appAccess.getResCenterId().toString());
				appAccessModel.setResCenterId("dev");
				//获取后场返回值 
				String result = null;
				//TODO逻辑？
				PcAppAccess old = appAccessSvc.queryById(appAccess.getId());
				if(appAccess.getId()==null){
					result = appAccessManager.add(JSON.toString(appAccessModel));
				}else{
					if(old==null)
						old = appAccessSvc.queryById(appAccess.getId());
					appAccessModel.setAccessCodeOld(old.getAccessCode());
					result = appAccessManager.modify(JSON.toString(appAccessModel));
				}
				AppAccessCodeUrl aacu = JSON.toObject(result, AppAccessCodeUrl.class);
				if("000000".equals(aacu.getCode())){
					PcAppAccess paa = new PcAppAccess();
					paa.setId(appAccess.getId());
					paa.setAccessUrl(aacu.getAccessUrl());
					appAccessSvc.saveOrUpdate(paa);
				}else{
					throw new ServiceException(" modify remote cfg error ! "); 
				}
			}
		}
		return null;
	}

	@Override
	public String asynremove(ParmDockerImage param) {
		//获取后场返回值 
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";
		String fullName = param.getDockerImage();
		CPcAppImage cpcAppImage = new CPcAppImage();
		cpcAppImage.setContainerFullName(fullName);
		List<PcAppImage> list = appImageSvc.queryList(cpcAppImage, "ID desc");
		if(list==null || list.size() == 0 ){
		}else{
			PcAppImage appImage = list.get(0);
			CPcAppAccess cdt = new CPcAppAccess();
			cdt.setAppId(appImage.getAppId());
			cdt.setAppImageId(appImage.getId());
			List<PcAppAccess> ls = appAccessSvc.queryList(cdt, null);
			if(ls!=null && ls.size()>0){
				PcAppAccess appAccess = ls.get(0);
				AppAccessModel appAccessModel = new AppAccessModel();
				appAccessModel.setContainer(fullName);
//				String dns = "_"+fullName+"._tcp.marathon."+resCenterSvc.queryById(appAccess.getResCenterId()).getDomain();
				String dns = "_"+fullName+"._tcp.marathon.ai";
				appAccessModel.setDns(dns);
				appAccessModel.setProtocol(appAccess.getProtocol());
				appAccessModel.setAccessCode(appAccess.getAccessCode());
				appAccessModel.setAccessCodeOld(appAccess.getAccessCode());
//				String resCenterId = appAccess.getResCenterId().toString();
				String resCenterId="dev";
				appAccessModel.setResCenterId(resCenterId);
				
				if("KILLED".equals(param.getTaskStatus())){
					result = appAccessManager.delete(JSON.toString(appAccessModel));
				}else if("RUNNING".equals(param.getTaskStatus())){
					result = appAccessManager.modify(JSON.toString(appAccessModel));
				}
			}
		}
		return result;
	}


}

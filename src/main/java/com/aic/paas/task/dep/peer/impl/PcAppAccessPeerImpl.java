package com.aic.paas.task.dep.peer.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.json.JSON;

public class PcAppAccessPeerImpl implements PcAppAccessPeer {
	static final Logger logger = LoggerFactory.getLogger(PcAppAccessPeerImpl.class);

	@Autowired
	PcAppAccessSvc pcAppAccessSvc;
	
	@Autowired
	IAppAccessManager appAccessManager;
	
	@Autowired
	PcAppImageSvc pcAppImageSvc;
	
	@Autowired
	PcResCenterSvc pcResCenterSvc;
	
	@Override
	public String saveOrUpdate(String record) {
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";

		PcAppAccess service = JSON.toObject(record, PcAppAccess.class);
		PcAppAccess old = pcAppAccessSvc.queryById(service.getId());
		//判断是否变化
		boolean change = checkChange(service,old);
		if(!change)
			return result;
		
		AppAccessModel param = new AppAccessModel();
		PcAppImage pai = pcAppImageSvc.queryById(service.getAppImageId());
		if(pai!=null)
			param.setContainer(pai.getContainerFullName());
		param.setAccessCode(service.getAccessCode());
		param.setAccessCodeOld(service.getAccessCode());
		PcResCenter resCenter = pcResCenterSvc.queryById(service.getResCenterId());
		if(pai!=null&&resCenter!=null)
//			param.setDns("_"+param.getContainer()+".marathon."+resCenter.getDomain());
			param.setDns("_"+param.getContainer()+"._tcp.marathon.ai");
		param.setProtocol(service.getProtocol());
//		param.setResCenterId(service.getResCenterId().toString());
		param.setResCenterId("dev");
		//获取后场返回值 
		if(service.getId()==null){
			result = appAccessManager.add(JSON.toString(param));
		}else{
			if(old==null)
				old = pcAppAccessSvc.queryById(service.getId());
			param.setAccessCodeOld(old.getAccessCode());
			result = appAccessManager.modify(JSON.toString(param));
		}
		AppAccessCodeUrl aacu = JSON.toObject(result, AppAccessCodeUrl.class);
		if("000000".equals(aacu.getCode())){
			PcAppAccess paa = new PcAppAccess();
			paa.setId(service.getId());
			paa.setAccessUrl(aacu.getAccessUrl());
			pcAppAccessSvc.saveOrUpdate(paa);
		}else{
			throw new ServiceException(" modify remote cfg error ! "); 
		}
		
		return result;
	}

	private boolean checkChange(PcAppAccess service,PcAppAccess old) {
		if(service.getId()==null)
			return true;
		if(!old.getAccessCode().equals(service.getAccessCode())||!old.getAppImageId().equals(service.getAppImageId())
				||!old.getProtocol().equals(service.getProtocol())
				||BinaryUtils.isEmpty(old.getAccessUrl())){
			return true;
		}
		return false;
	}

	@Override
	public String remove(String record) {
		PcAppAccess service = JSON.toObject(record, PcAppAccess.class);
		PcAppAccess access = pcAppAccessSvc.queryById(service.getId());
		//获取后场返回值 
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";
		AppAccessModel appAccessModel = new AppAccessModel();
		/**PcAppImage appImage = pcAppImageSvc.queryById(access.getAppImageId());
		String fullName = appImage.getContainerFullName();
		appAccessModel.setContainer(fullName);
//		String dns = "_"+fullName+"._tcp.marathon."+resCenterSvc.queryById(access.getResCenterId()).getDomain();
		String dns = "_"+fullName+"._tcp.marathon.ai";
		appAccessModel.setDns(dns);*/
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
	public String asynChange(ParmDockerImage param) {
		AppAccessModel appAccessModel = new AppAccessModel();
		//获取后场返回值 
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";
		String fullName = param.getDockerImage();
		CPcAppImage cpcAppImage = new CPcAppImage();
		cpcAppImage.setContainerFullName(fullName);
		List<PcAppImage> list = pcAppImageSvc.queryList(cpcAppImage, "ID desc");
		if(list == null || list.size() == 0 ){
			return result;
		}
		
		PcAppImage appImage = list.get(0);
		CPcAppAccess cdt = new CPcAppAccess();
		cdt.setAppId(appImage.getAppId());
		cdt.setAppImageId(appImage.getId());
		List<PcAppAccess> ls = pcAppAccessSvc.queryList(cdt, null);
		if(ls==null || ls.size() == 0 ){
			return result;
		}
		PcAppAccess appAccess = ls.get(0);
		if(appImage!=null)
			appAccessModel.setContainer(appImage.getContainerFullName());
		appAccessModel.setAccessCode(appAccess.getAccessCode());
		appAccessModel.setAccessCodeOld(appAccess.getAccessCode());
		PcResCenter resCenter = pcResCenterSvc.queryById(appAccess.getResCenterId());
		if(appImage!=null&&resCenter!=null)
//					appAccessModel.setDns("_"+appAccessModel.getContainer()+".marathon."+resCenter.getDomain());
			appAccessModel.setDns("_"+appAccessModel.getContainer()+"._tcp.marathon.ai");
		appAccessModel.setProtocol(appAccess.getProtocol());
//				appAccessModel.setResCenterId(appAccess.getResCenterId().toString());
		appAccessModel.setResCenterId("dev");
		
		
		if("KILLED".equals(param.getTaskStatus())){
			result = appAccessManager.delete(JSON.toString(appAccessModel));
		}else if("RUNNING".equals(param.getTaskStatus())){
			result = appAccessManager.modify(JSON.toString(appAccessModel));
		}
		
		AppAccessCodeUrl aacu = JSON.toObject(result, AppAccessCodeUrl.class);
		if(!"000000".equals(aacu.getCode())){
			throw new ServiceException(" modify remote cfg error ! "); 
		}
		return result;
	}

	@Override
	public String saveOrUpdateByImg(String record) {
		PcAppImage service = JSON.toObject(record, PcAppImage.class);
		PcAppImage pcAppImage = pcAppImageSvc.queryById(service.getId());
		String result = "{\"code\":\"000000\",\"msg\":\"ok\"}";
//		AppAccessModel appAccessModel = new AppAccessModel();
		CPcAppAccess cpcAppAccess = new CPcAppAccess(); 
		cpcAppAccess.setAppId(pcAppImage.getId());
		cpcAppAccess.setAppImageId(pcAppImage.getImageId());
		List<PcAppAccess> list = pcAppAccessSvc.queryList(cpcAppAccess, null);
		if(list==null || list.size()==0){
			return result;
		}
		PcAppAccess pcAppAccess = list.get(0);
		if(service.getCustom1()==1){
			result = saveOrUpdate(JSON.toString(pcAppAccess));
		}else{
			result = remove(JSON.toString(pcAppAccess));
		}
		return result;
	}
	


}

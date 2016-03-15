package com.aic.paas.task.peer.dev.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.AppImageSettings;
import com.aic.paas.task.bean.dep.AppImageSvcInfo;
import com.aic.paas.task.bean.dep.GeneralDeployResp;
import com.aic.paas.task.bean.dep.GeneralReq;
import com.aic.paas.task.bean.dep.GeneralReq.Container;
import com.aic.paas.task.bean.dep.GeneralReq.Container.For;
import com.aic.paas.task.bean.dep.Parameter;
import com.aic.paas.task.bean.dep.PcApp;
import com.aic.paas.task.bean.dep.PcAppDepHistory;
import com.aic.paas.task.bean.dep.PcAppImage;
import com.aic.paas.task.bean.dep.PcAppTask;
import com.aic.paas.task.bean.dep.PcKvPair;
import com.aic.paas.task.bean.dev.CPcImage;
import com.aic.paas.task.bean.dev.PcImage;
import com.aic.paas.task.mvc.dep.bean.ActionType;
import com.aic.paas.task.peer.dep.PcAppImagePeer;
import com.aic.paas.task.peer.dep.bean.LogReq;
import com.aic.paas.task.peer.dev.PcBuildPeer;
import com.aic.paas.task.rest.dep.IDeployServiceManager;
import com.aic.paas.task.rest.dep.PcAppDepHistorySvc;
import com.aic.paas.task.rest.dep.PcAppImageSvc;
import com.aic.paas.task.rest.dep.PcAppSvc;
import com.aic.paas.task.rest.dep.PcAppTaskSvc;
import com.aic.paas.task.rest.dep.PcAppVersionSvc;
import com.aic.paas.task.rest.dev.PcImageSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.json.JSON;

public class PcBuildPeerImpl implements PcBuildPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildPeerImpl.class);

	//@Autowired
	//PcAppImageSvc appImageSvc;

	
	@Override
	public String removePcBuildApi(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

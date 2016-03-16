package com.aic.paas.task.peer.sys.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.sys.CWsMerchent;
import com.aic.paas.task.bean.sys.WsMerchent;
import com.aic.paas.task.peer.sys.WsMerchentPeer;
import com.aic.paas.task.rest.sys.MerchentSvc;

public class WsMerchentPeerImpl implements WsMerchentPeer {

	static final Logger logger = LoggerFactory.getLogger(WsMerchentPeerImpl.class);

	@Autowired
	MerchentSvc merchentSvc;

	@Override
	public List<WsMerchent> queryList(CWsMerchent cdt, String orders) {
		
		return merchentSvc.queryList(cdt, orders);
	}

	

}
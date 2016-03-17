package com.aic.paas.task.sys.peer.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.sys.bean.CWsMerchent;
import com.aic.paas.task.sys.bean.WsMerchent;
import com.aic.paas.task.sys.peer.WsMerchentPeer;
import com.aic.paas.task.sys.rest.MerchentSvc;

public class WsMerchentPeerImpl implements WsMerchentPeer {

	static final Logger logger = LoggerFactory.getLogger(WsMerchentPeerImpl.class);

	@Autowired
	MerchentSvc merchentSvc;

	@Override
	public List<WsMerchent> queryList(CWsMerchent cdt, String orders) {
		
		return merchentSvc.queryList(cdt, orders);
	}

	

}
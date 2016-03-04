package com.aic.paas.task.msg.support.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcAppMgr;
import com.aic.paas.task.bean.dep.PcAppMgr;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcAppSvc;

public class PcAppMgrMsg  extends AbstractMessage<PcAppMgr, CPcAppMgr> {

	
	@Autowired
	PcAppSvc appSvc;
	
	
	
	@Override
	public MsgType getType() {
		return MsgType.USER_APP;
	}
	
	
	@Override
	public Class<PcAppMgr> getEntityClass() {
		return PcAppMgr.class;
	}
	
	
	@Override
	public Class<CPcAppMgr> getConditionClass() {
		return CPcAppMgr.class;
	}
	
	

	@Override
	public List<PcAppMgr> queryList(long pageNum, long pageSize, CPcAppMgr cdt,String orders) {
		return appSvc.queryAppMgrPage2((int)pageNum, (int)pageSize, cdt, orders);
	}


	
	
	@Override
	public List<PcAppMgr> queryList(CPcAppMgr cdt, String orders) {
		return appSvc.queryAppMgrList(cdt, orders);
	}
	
	
	
}

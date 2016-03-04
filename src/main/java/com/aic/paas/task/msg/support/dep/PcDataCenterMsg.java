package com.aic.paas.task.msg.support.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcDataCenter;
import com.aic.paas.task.bean.dep.PcDataCenter;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcDataCenterSvc;

public class PcDataCenterMsg  extends AbstractMessage<PcDataCenter, CPcDataCenter> {

	@Autowired
	PcDataCenterSvc dcSvc;
	
	
	
	@Override
	public MsgType getType() {
		return MsgType.DC;
	}

	
	@Override
	public Class<PcDataCenter> getEntityClass() {
		return PcDataCenter.class;
	}
	
	
	@Override
	public Class<CPcDataCenter> getConditionClass() {
		return CPcDataCenter.class;
	}
	
	
	

	@Override
	public List<PcDataCenter> queryList(long pageNum, long pageSize,CPcDataCenter cdt, String orders) {
		return dcSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
	}
	
	


	
	@Override
	public List<PcDataCenter> queryList(CPcDataCenter cdt, String orders) {
		return dcSvc.queryList(cdt, orders);
	}
	
	
	

}

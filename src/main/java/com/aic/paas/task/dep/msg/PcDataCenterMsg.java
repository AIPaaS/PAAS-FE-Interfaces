package com.aic.paas.task.dep.msg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.CPcDataCenter;
import com.aic.paas.task.dep.bean.PcDataCenter;
import com.aic.paas.task.dep.rest.PcDataCenterSvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;

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

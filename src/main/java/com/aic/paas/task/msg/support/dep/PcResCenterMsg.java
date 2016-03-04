package com.aic.paas.task.msg.support.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcResCenter;
import com.aic.paas.task.bean.dep.PcResCenter;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcResCenterSvc;

public class PcResCenterMsg  extends AbstractMessage<PcResCenter, CPcResCenter> {

	
	@Autowired
	PcResCenterSvc rcSvc;
	
	
	
	@Override
	public MsgType getType() {
		return MsgType.RC;
	}

	
	@Override
	public Class<PcResCenter> getEntityClass() {
		return PcResCenter.class;
	}
	
	
	@Override
	public Class<CPcResCenter> getConditionClass() {
		return CPcResCenter.class;
	}
	
	

	@Override
	public List<PcResCenter> queryList(long pageNum, long pageSize,CPcResCenter cdt, String orders) {
		return rcSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
	}

	
	

	
	@Override
	public List<PcResCenter> queryList(CPcResCenter cdt, String orders) {
		return rcSvc.queryList(cdt, orders);
	}
	
	
	

}

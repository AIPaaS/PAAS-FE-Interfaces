package com.aic.paas.task.dep.msg.send;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.CPcResCenter;
import com.aic.paas.task.dep.bean.PcResCenter;
import com.aic.paas.task.dep.rest.PcResCenterSvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;

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

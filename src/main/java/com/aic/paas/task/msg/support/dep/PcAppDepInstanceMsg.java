package com.aic.paas.task.msg.support.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcAppDepInstance;
import com.aic.paas.task.bean.dep.PcAppDepInstance;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcAppDeploySvc;

public class PcAppDepInstanceMsg extends AbstractMessage<PcAppDepInstance, CPcAppDepInstance> {

	
	@Autowired
	PcAppDeploySvc appDepSvc;
	
	
	@Override
	public MsgType getType() {
		return MsgType.CONT_INST;
	}
	
	
	@Override
	public Class<PcAppDepInstance> getEntityClass() {
		return PcAppDepInstance.class;
	}
	
	
	@Override
	public Class<CPcAppDepInstance> getConditionClass() {
		return CPcAppDepInstance.class;
	}

	

	@Override
	public List<PcAppDepInstance> queryList(long pageNum, long pageSize,CPcAppDepInstance cdt, String orders) {
		return appDepSvc.queryDepInstancePage2((int)pageNum, (int)pageSize, cdt, orders);
	}

	
	
	@Override
	public List<PcAppDepInstance> queryList(CPcAppDepInstance cdt, String orders) {
		return appDepSvc.queryDepInstanceList(cdt, orders);
	}
	
	

}

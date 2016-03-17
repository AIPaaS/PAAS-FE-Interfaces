package com.aic.paas.task.dep.msg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.CPcAppDepInstance;
import com.aic.paas.task.dep.bean.PcAppDepInstance;
import com.aic.paas.task.dep.rest.PcAppDeploySvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;

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

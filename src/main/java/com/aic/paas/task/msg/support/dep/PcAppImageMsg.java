package com.aic.paas.task.msg.support.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcAppDepHistory;
import com.aic.paas.task.bean.dep.PcAppDepHistory;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcAppDeploySvc;

public class PcAppImageMsg  extends AbstractMessage<PcAppDepHistory, CPcAppDepHistory> {

	
	@Autowired
	PcAppDeploySvc appDepSvc;
	
	
	
	@Override
	public MsgType getType() {
		return MsgType.CONT;
	}
	
	
	@Override
	public Class<PcAppDepHistory> getEntityClass() {
		return PcAppDepHistory.class;
	}
	
	
	@Override
	public Class<CPcAppDepHistory> getConditionClass() {
		return CPcAppDepHistory.class;
	}
	
	

	@Override
	public List<PcAppDepHistory> queryList(long pageNum, long pageSize,CPcAppDepHistory cdt, String orders) {
		return appDepSvc.queryDepHistoryPage2((int)pageNum, (int)pageSize, cdt, orders);
	}

	
	@Override
	public List<PcAppDepHistory> queryList(CPcAppDepHistory cdt, String orders) {
		return appDepSvc.queryDepHistoryList(cdt, orders);
	}
	
	

}

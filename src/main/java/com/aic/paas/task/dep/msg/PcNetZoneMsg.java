package com.aic.paas.task.dep.msg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.CPcNetZone;
import com.aic.paas.task.dep.bean.PcNetZone;
import com.aic.paas.task.dep.rest.PcNetZoneSvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;

public class PcNetZoneMsg  extends AbstractMessage<PcNetZone, CPcNetZone> {
	
	
	@Autowired
	PcNetZoneSvc nzSvc;
	
	
	
	@Override
	public MsgType getType() {
		return MsgType.NC;
	}

	
	@Override
	public Class<PcNetZone> getEntityClass() {
		return PcNetZone.class;
	}
	
	
	@Override
	public Class<CPcNetZone> getConditionClass() {
		return CPcNetZone.class;
	}
	
	

	@Override
	public List<PcNetZone> queryList(long pageNum, long pageSize,CPcNetZone cdt, String orders) {
		return nzSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
	}

	
	

	
	@Override
	public List<PcNetZone> queryList(CPcNetZone cdt, String orders) {
		return nzSvc.queryList(cdt, orders);
	}
	
	
	

}

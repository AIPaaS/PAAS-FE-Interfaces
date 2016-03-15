package com.aic.paas.task.msg.support.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.sys.CSysOp;
import com.aic.paas.task.bean.sys.SysOp;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.sys.SysOpSvc;

public class SysOpMsg  extends AbstractMessage<SysOp, CSysOp> {

	
	@Autowired
	SysOpSvc opSvc;
	
	
	@Override
	public MsgType getType() {
		return MsgType.USER;
	}

	
	@Override
	public Class<SysOp> getEntityClass() {
		return SysOp.class;
	}
	
	
	@Override
	public Class<CSysOp> getConditionClass() {
		return CSysOp.class;
	}
	


	
	
	@Override
	public List<SysOp> queryList(long pageNum, long pageSize, CSysOp cdt, String orders) {
		if(cdt == null) cdt = new CSysOp();
		cdt.setOpKind(2);	//1=平台用户		2=租户用户
		return opSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
	}

	
	
	
	

	
	@Override
	public List<SysOp> queryList(CSysOp cdt, String orders) {
		cdt.setOpKind(2);	//1=平台用户		2=租户用户
		return opSvc.queryList(cdt, orders);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

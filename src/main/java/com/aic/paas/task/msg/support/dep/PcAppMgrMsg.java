package com.aic.paas.task.msg.support.dep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.AppMgr;
import com.aic.paas.task.bean.dep.CPcAppMgr;
import com.aic.paas.task.bean.dep.CPcAppVersion;
import com.aic.paas.task.bean.dep.PcAppMgr;
import com.aic.paas.task.bean.dep.PcAppVersion;
import com.aic.paas.task.bean.sys.CSysOp;
import com.aic.paas.task.bean.sys.SysOp;
import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.msg.support.AbstractMessage;
import com.aic.paas.task.rest.dep.PcAppSvc;
import com.aic.paas.task.rest.sys.SysOpSvc;
import com.binary.core.util.BinaryUtils;

public class PcAppMgrMsg  extends AbstractMessage<AppMgr, CSysOp> {

	
	@Autowired
	PcAppSvc appSvc;
	
	@Autowired
	SysOpSvc opSvc;
	
	
	@Override
	public MsgType getType() {
		return MsgType.USER_APP;
	}
	
	
	@Override
	public Class<AppMgr> getEntityClass() {
		return AppMgr.class;
	}
	
	
	@Override
	public Class<CSysOp> getConditionClass() {
		return CSysOp.class;
	}
	
	
	
	
	private List<AppMgr> toAppMgrList(List<SysOp> opls) {
		List<AppMgr> mgrls = new ArrayList<AppMgr>();
		
		if(opls.size() > 0) {
			Long time = BinaryUtils.getNumberDateTime();
			
			Long[] opIds = new Long[opls.size()];
			for(int i=0; i<opls.size(); i++) {
				SysOp op = opls.get(i);
				opIds[i] = op.getId();
				
				AppMgr am = new AppMgr();
				am.setId(op.getId());
				am.setCreateTime(time-1);
				am.setModifyTime(time);
				mgrls.add(am);
			}
			
			CPcAppMgr amcdt = new CPcAppMgr();
			amcdt.setUserIds(opIds);
			List<PcAppMgr> amls = appSvc.queryAppMgrList(amcdt, null);
			
			if(amls.size() > 0) {
				Map<Long, List<PcAppMgr>> ammap = BinaryUtils.toObjectGroupMap(amls, "userId");
				
				Set<Long> appIds = new HashSet<Long>();
				for(int i=0; i<amls.size(); i++) {
					PcAppMgr am = amls.get(i);
					appIds.add(am.getAppId());
				}
				
				CPcAppVersion avcdt = new CPcAppVersion();
				avcdt.setAppIds(appIds.toArray(new Long[0]));
				List<PcAppVersion> avls = appSvc.queryAppVersionList(avcdt, null);
				
				if(avls.size() > 0) {
					Map<Long, List<PcAppVersion>> avmap = BinaryUtils.toObjectGroupMap(avls, "appId");
					
					for(int i=0; i<mgrls.size(); i++) {
						AppMgr am = mgrls.get(i);
						Long userId = am.getUserId();
						Set<Long> verids = new HashSet<Long>();
						
						List<PcAppMgr> mls = ammap.get(userId);
						if(mls!=null && mls.size()>0) {
							for(int j=0; j<mls.size(); j++) {
								PcAppMgr m = mls.get(j);
								Long appId = m.getAppId();
								
								List<PcAppVersion> vls = avmap.get(appId);
								if(vls!=null && vls.size()>0) {
									for(int k=0; k<vls.size(); k++) {
										PcAppVersion v = vls.get(k);
										verids.add(v.getId());
									}
								}
							}
						}
						
						am.setAppIds(verids.toArray(new Long[0]));
					}
				}
			}
			
		}
		
		return mgrls;
	}
	
	
	

	@Override
	public List<AppMgr> queryList(long pageNum, long pageSize, CSysOp cdt,String orders) {
		if(cdt != null) cdt.setStartModifyTime(0l);
		
		List<SysOp> opls = opSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
		return toAppMgrList(opls);
	}


	
	
	@Override
	public List<AppMgr> queryList(CSysOp cdt, String orders) {
		if(cdt != null) cdt.setStartModifyTime(0l);
		List<SysOp> opls = opSvc.queryList(cdt, orders);
		return toAppMgrList(opls);
	}
	
	
	
	
	
	
}

package com.aic.paas.task.dep.msg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.AppMgr;
import com.aic.paas.task.dep.bean.CPcAppMgr;
import com.aic.paas.task.dep.bean.CPcAppVersion;
import com.aic.paas.task.dep.bean.PcAppMgr;
import com.aic.paas.task.dep.bean.PcAppVersion;
import com.aic.paas.task.dep.rest.PcAppSvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;
import com.aic.paas.task.sys.rest.SysOpSvc;
import com.binary.core.util.BinaryUtils;

public class PcAppMgrMsg  extends AbstractMessage<AppMgr, CPcAppMgr> {

	
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
	public Class<CPcAppMgr> getConditionClass() {
		return CPcAppMgr.class;
	}
	
	
	
	
	private List<AppMgr> toAppMgrList(Long[] opIds, Long lastTime) {
		List<AppMgr> mgrls = new ArrayList<AppMgr>();
		
		if(opIds.length > 0) {
			for(int i=0; i<opIds.length; i++) {
				AppMgr am = new AppMgr();
				am.setId(opIds[i]);
				am.setCreateTime(lastTime-1);
				am.setModifyTime(lastTime);
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
	public List<AppMgr> queryList(long pageNum, long pageSize, CPcAppMgr cdt,String orders) {
		//List<SysOp> opls = opSvc.queryPage2((int)pageNum, (int)pageSize, cdt, orders);
		return queryList(cdt, orders);
	}


	
	
	@Override
	public List<AppMgr> queryList(CPcAppMgr cdt, String orders) {
		List<PcAppMgr> ls = appSvc.queryAppMgrList(cdt, orders);
		Set<Long> opIds = new HashSet<Long>();
		Long lastTime = 0l;
		
		for(int i=0; i<ls.size(); i++) {
			PcAppMgr p = ls.get(i);
			Long userId = p.getUserId();
			opIds.add(userId);
			
			Long time = p.getModifyTime();
			if(time > lastTime) {
				lastTime = time;
			}
		}
		
		return toAppMgrList(opIds.toArray(new Long[0]), lastTime);
	}
	
	
	
	
	
	
}

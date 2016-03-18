package com.aic.paas.task.dep.msg.send;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.dep.bean.App;
import com.aic.paas.task.dep.bean.CPcApp;
import com.aic.paas.task.dep.bean.CPcAppVersion;
import com.aic.paas.task.dep.bean.PcApp;
import com.aic.paas.task.dep.bean.PcAppVersion;
import com.aic.paas.task.dep.rest.PcAppSvc;
import com.aic.paas.task.msg.send.msg.AbstractMessage;
import com.aic.paas.task.msg.send.msg.MsgType;
import com.binary.core.bean.BMProxy;
import com.binary.core.util.BinaryUtils;

public class PcAppMsg  extends AbstractMessage<App, CPcAppVersion> {

	@Autowired
	PcAppSvc appSvc;
		
	
	@Override
	public MsgType getType() {
		return MsgType.APP;
	}

	
	@Override
	public Class<App> getEntityClass() {
		return App.class;
	}
	
	
	@Override
	public Class<CPcAppVersion> getConditionClass() {
		return CPcAppVersion.class;
	}
	
	
	
	
	private List<App> toAppList(List<PcAppVersion> vnols) {
		List<App> appls = new ArrayList<App>();
		if(vnols.size() > 0) {
			Set<Long> appIds = new HashSet<Long>();
			for(int i=0; i<vnols.size(); i++) {
				PcAppVersion ver = vnols.get(i);
				appIds.add(ver.getAppId());
			}
			
			CPcApp appcdt = new CPcApp();
			appcdt.setIds(appIds.toArray(new Long[0]));
			List<PcApp> als = appSvc.queryList(appcdt, null);
			
			Map<Long, PcApp> amap = BinaryUtils.toObjectMap(als, "id");
			
			BMProxy<App> proxy = BMProxy.getInstance(App.class);
			
			for(int i=0; i<vnols.size(); i++) {
				PcAppVersion ver = vnols.get(i);
				PcApp a = amap.get(ver.getAppId());
				
				App app = proxy.newInstance();
				if(a != null) {
					proxy.copyFrom(a);
				}else {
					app.setStatus(0);
				}
				
				app.setId(ver.getId());
				app.setMntId(ver.getMntId());
				app.setVersionNo(ver.getVersionNo());
				app.setSetupStatus(ver.getSetupStatus());
				app.setStatus(ver.getStatus());
				app.setCreateTime(ver.getCreateTime());
				app.setModifyTime(ver.getModifyTime());
				appls.add(app);
			}
		}
		
		return appls;
	}
	
	
	

	@Override
	public List<App> queryList(long pageNum, long pageSize, CPcAppVersion cdt,String orders) {
		List<PcAppVersion> vnols = appSvc.queryAppVersionPage2((int)pageNum, (int)pageSize, cdt, orders);
		return toAppList(vnols);
	}

	

	@Override
	public List<App> queryList(CPcAppVersion cdt, String orders) {
		List<PcAppVersion> vnols = appSvc.queryAppVersionList(cdt, orders);
		return toAppList(vnols);
	}
	
	
	

}

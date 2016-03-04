package com.aic.paas.task.peer.dep.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.AppImageSettings;
import com.aic.paas.task.bean.dev.CPcImage;
import com.aic.paas.task.bean.dev.PcImage;
import com.aic.paas.task.peer.dep.PcAppImagePeer;
import com.aic.paas.task.rest.dep.PcAppImageSvc;
import com.aic.paas.task.rest.dev.PcImageSvc;
import com.binary.core.util.BinaryUtils;

public class PcAppImagePeerImpl implements PcAppImagePeer {
	
	
	@Autowired
	PcAppImageSvc appImageSvc;
	
	
	@Autowired
	PcImageSvc imageSvc;
	
	

	@Override
	public AppImageSettings getAppImageSettings(Long appImageId) {
		AppImageSettings settings = appImageSvc.getAppImageSettings(appImageId);
		if(settings != null) {
			Long imageId = settings.getAppImage().getImageId();
			if(imageId != null) {
				PcImage image = imageSvc.queryImageById(imageId);
				settings.setImage(image);
			}
		}
		return settings;
	}
	
	
	
	@Override
	public List<AppImageSettings> getAppImageSettingsList(Long appId, Long appVnoId) {
		List<AppImageSettings> settingsList = appImageSvc.getAppImageSettingsList(appId, appVnoId);
		
		if(settingsList!=null && settingsList.size()>0) {
			Set<Long> imageids = new HashSet<Long>();
			for(int i=0; i<settingsList.size(); i++) {
				AppImageSettings settings = settingsList.get(i);
				imageids.add(settings.getAppImage().getImageId());
			}
			
			CPcImage imgcdt = new CPcImage();
			imgcdt.setIds(imageids.toArray(new Long[0]));
			List<PcImage> images = imageSvc.queryImageList(imgcdt, null);
			
			Map<Long, PcImage> imgmap = BinaryUtils.toObjectMap(images, "ID");
			
			for(int i=0; i<settingsList.size(); i++) {
				AppImageSettings settings = settingsList.get(i);
				Long imageId = settings.getAppImage().getImageId();
				PcImage image = imgmap.get(imageId);
				settings.setImage(image);
			}
		}
		
		return settingsList;
	}



	
	
	
	@Override
	public void startDeploy(Long appId, Long appVnoId) {
		// TODO Auto-generated method stub
		
	}
	

	
	

	@Override
	public void reDeploy(Long appId, Long appVnoId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void stopDeploy(Long appId, Long appVnoId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}

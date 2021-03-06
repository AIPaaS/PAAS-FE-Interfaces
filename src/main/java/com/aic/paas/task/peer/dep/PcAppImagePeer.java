package com.aic.paas.task.peer.dep;

import java.util.List;

import com.aic.paas.task.bean.dep.AppImageSettings;

public interface PcAppImagePeer {
	
	
	
	
	/**
	 * 获取镜像所有配置信息
	 * @param appImageId
	 * @return
	 */
	public AppImageSettings getAppImageSettings(Long appImageId);
	
	
	
	
	/**
	 * 获取应用下所有容器配置
	 * @param appId
	 * @param appVnoId
	 * @return
	 */
	public List<AppImageSettings> getAppImageSettingsList(Long appId, Long appVnoId);
	
	
	
	
	
	/**
	 * 开始部署
	 * @param appId
	 * @param appVnoId
	 */
	public String startDeploy(Long appId, Long appVnoId);
	
	
	
	/**
	 * 重新部署
	 * @param appId
	 * @param appVnoId
	 */
	public String reDeploy(Long appId, Long appVnoId);
	
	
	
	
	/**
	 * 停止部署
	 * @param appId
	 * @param appVnoId
	 */
	public String destroyDeploy(Long appId, Long appVnoId);
	
	/**
	 * 开始运行应用
	 * @param appId
	 * @param appVnoId
	 */
	public String startApp(Long appId, Long appVnoId);
	
	/**
	 * 暂停运行应用
	 * @param appId
	 * @param appVnoId
	 */
	public String pauseApp(Long appId, Long appVnoId);
	
	

}

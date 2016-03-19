package com.aic.paas.task.dep.peer;

import java.util.List;

import com.aic.paas.task.dep.bean.AppImageSettings;
import com.aic.paas.task.dep.bean.GeneralDeployResp;

public interface PcAppImagePeer {

	/**
	 * 获取镜像所有配置信息
	 * 
	 * @param appImageId
	 * @return
	 */
	public AppImageSettings getAppImageSettings(Long appImageId);

	/**
	 * 获取应用下所有容器配置
	 * 
	 * @param appId
	 * @param appVnoId
	 * @return
	 */
	public List<AppImageSettings> getAppImageSettingsList(Long appId, Long appVnoId);

	/**
	 * 开始部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	public String startDeploy(Long appId, Long appVnoId);

	/**
	 * 重新部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	public String reDeploy(Long appId, Long appVnoId);

	/**
	 * 停止部署
	 * 
	 * @param appId
	 */
	public String destroyDeploy(Long appId);

	/**
	 * 开始运行应用
	 * 
	 * @param appId
	 */
	public String startApp(Long appId);

	/**
	 * 暂停运行应用
	 * 
	 * @param appId
	 */
	public String pauseApp(Long appId);

	/**
	 * 重新开始应用	
	 * @param appId
	 * @return
	 */
	public String resumeApp(Long appId);
	/**
	 * 获取应用日志
	 * 
	 * @param appId
	 */
	public String fetchLog(Long appId, Long reqId, Long time);
	
	/**
	 * 获取应用状态信息
	 * 
	 * @param appId
	 */
	public String appStatus(Long appId);
	
	/**
	 * 开始部署定时应用
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	public String startTimerDeploy(Long appId, Long appVnoId);

	/**
	 * 重新部署定时
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	public String reDeployTimer(Long appId, Long appVnoId);

	/**
	 * 停止部署定时
	 * 
	 * @param appId
	 */
	public String destroyDeployTimer(Long appId);

	/**
	 * 开始运行定时应用
	 * 
	 * @param appId
	 */
	public String starTimertApp(Long appId);

	/**
	 * 获取定时应用状态信息
	 * 
	 * @param appId
	 */
	public String appTimerStatus(Long appId);

	void writeAppDepHistory(Long appId, Long appVnoId, GeneralDeployResp resp, Integer runStatus);

	void updateDepHistory(Long appId, Long appVnoId, Integer runStatus, Integer preRunStatus);

}

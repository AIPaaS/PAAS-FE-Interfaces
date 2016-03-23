package com.aic.paas.task.peer.res;

public interface PcResManagePeer {
	
	/**
	 * 资源中心部署的日志查询
	 * @param clusterId
	 */
	public String queryLog(Long clusterId);

}

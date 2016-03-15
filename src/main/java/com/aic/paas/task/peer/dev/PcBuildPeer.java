package com.aic.paas.task.peer.dev;


public interface PcBuildPeer {
	/**
	 * hyh.  2016.3.15
	 * 删除构建时，掉对方接口
	 * 
	 * @param appImageId
	 * @return
	 */
	public String removePcBuildApi(String param);
	
	/**
	 * 查询单条构建记录
	 * @param namespace
	 * @param repo_name
	 * @param build_id
	 * @return
	 */
	public String queryTaskRecord(String namespace, String repo_name, String build_id);
}

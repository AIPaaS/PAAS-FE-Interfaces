package com.aic.paas.task.peer.dev;


public interface PcBuildTaskPeer {
	/**
	 * hyh.  2016.3.15
	 * 中止构建时，掉对方接口
	 * 
	 * @param appImageId
	 * @return
	 */
	public String stopPcBuildTaskApi(String param);
	
	/**
	 * 查询单条构建记录
	 * @param namespace
	 * @param repo_name
	 * @param build_id
	 * @return
	 */
	public String queryTaskRecord(String namespace, String repo_name, String build_id) throws Exception;
}

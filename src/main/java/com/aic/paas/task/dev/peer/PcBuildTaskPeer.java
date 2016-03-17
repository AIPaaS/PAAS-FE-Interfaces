package com.aic.paas.task.dev.peer;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;


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

	/**
	 * 不分页查询
	 * @param pbtc : 构建任务回调对象
	 * @param imgRespId : 所属镜像库Id
	 * @return 
	 */
	public String updateBuildTaskByCallBack(PcBuildTaskCallBack pbtc);
	/**
	 * 保存构建任务
	 * @param param : 传递的参数
	 * @param 
	 * @return 
	 */
	public String saveBuildTask(String param);
}

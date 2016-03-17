package com.aic.paas.task.dev.rest;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;


public interface PcBuildTaskSvc {
	

	/**
	 * 不分页查询
	 * @param pbtc : 构建任务回调对象
	 * @param imgRespId : 所属镜像库Id
	 * @return 
	 */
	public String updateBuildTaskByCallBack(PcBuildTaskCallBack pbtc,String imgRespId);
}
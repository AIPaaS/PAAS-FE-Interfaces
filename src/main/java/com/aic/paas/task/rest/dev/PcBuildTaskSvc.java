package com.aic.paas.task.rest.dev;

import com.aic.paas.task.mvc.dev.bean.PcBuildTaskCallBack;


public interface PcBuildTaskSvc {
	

	/**
	 * 不分页查询
	 * @param pbtc : 构建任务回调对象
	 * @param imgRespId : 所属镜像库Id
	 * @return 
	 */
	public String updateBuildTaskByCallBack(PcBuildTaskCallBack pbtc,String imgRespId);
}
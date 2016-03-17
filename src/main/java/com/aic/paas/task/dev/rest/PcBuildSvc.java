package com.aic.paas.task.dev.rest;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;

public interface PcBuildSvc {
	
	/**
	 * 根据回调函数，查询所属机房的Id
	 * @param pbtc 构建任务的回调对象
	 * @return 该构建任务所属的构建定义的产品的所属机房的Id
	 */
	public String queryCompRoomIdByCallBack(PcBuildTaskCallBack pbtc);
}

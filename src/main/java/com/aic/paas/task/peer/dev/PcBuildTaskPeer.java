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
}

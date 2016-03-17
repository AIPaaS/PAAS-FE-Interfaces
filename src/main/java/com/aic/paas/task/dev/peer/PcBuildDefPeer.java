package com.aic.paas.task.dev.peer;




public interface PcBuildDefPeer {
	/**
	 * 构建接口调用
	 * @param param
	 * @return
	 */
	public String buildDefApi(String param);
	/**
	 * 修改构建接口调用
	 * @param param
	 * @return
	 */
	public String updateBuildDefApi(String param);
	
}

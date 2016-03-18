package com.aic.paas.task.dev.peer;

public interface PcImagePeer {
	
	/**
	 * @param param 上传镜像所传递的参数
	 * @return success 回调成功；error回调失败
	 */
	public String uploadImage(String param);
	
	/**
	 * @param param 回调方法，返回的参数
	 * @return success 回调成功；error回调失败
	 */
	public String updateImageByCallBack(String param);
}

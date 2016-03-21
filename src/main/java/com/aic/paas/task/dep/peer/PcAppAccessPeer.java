package com.aic.paas.task.dep.peer;

import com.aic.paas.task.dep.bean.ParmDockerImage;

public interface PcAppAccessPeer {
	/**
	 * 通过页面维护，修改服务器上的haproxy.cfg
	 * @param record PcAppAccess
	 * @return
	 */
	String saveOrUpdate(String   record);
	
	/**通过页面维护，修改服务器上的haproxy.cfg
	 * @param record PcAppAccess
	 * @return
	 */
	String remove(String   record);
	
	/**
	 * 通过消息，修改服务器上的haproxy.cfg
	 * @param record ParmDockerImage
	 * @return
	 */
	String asynChange(ParmDockerImage   record);

	
	/**
	 * 通过页面维护，修改服务器上的haproxy.cfg
	 * 通过容器定义--触发
	 * @param record  PcAppImage
	 * @return
	 */
	String saveOrUpdateByImg(String   record);
}

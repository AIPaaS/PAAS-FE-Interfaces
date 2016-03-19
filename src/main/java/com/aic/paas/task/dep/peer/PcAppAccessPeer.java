package com.aic.paas.task.dep.peer;

import com.aic.paas.task.dep.bean.ParmDockerImage;

public interface PcAppAccessPeer {
	String saveOrUpdate(String   record);
	String remove(String   record);
	
	String asynsaveOrUpdate(ParmDockerImage   record);
	String asynremove(ParmDockerImage   record);

}

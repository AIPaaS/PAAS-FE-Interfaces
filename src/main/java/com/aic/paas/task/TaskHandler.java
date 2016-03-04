package com.aic.paas.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.aic.paas.task.util.TaskUtil;
import com.binary.framework.ApplicationListener;


public class TaskHandler implements ApplicationListener {
	private static Logger log = LoggerFactory.getLogger(TaskHandler.class);
	
	
	

	@Override
	public void afterInitialization(ApplicationContext context) {
		log.info(" replace dao-definition ... ");
		TaskUtil.replaceAllDaoDefinition(context);
		log.info(" replace dao-definition successful. ");
	}
	
	
	
	
}

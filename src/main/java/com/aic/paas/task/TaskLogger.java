package com.aic.paas.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binary.task.TaskJob;
import com.binary.task.TaskLog;
import com.binary.task.TaskLogType;
import com.binary.task.TaskManager;

public class TaskLogger implements TaskLog {
	private static final Logger logger = LoggerFactory.getLogger(TaskLogger.class);
	
	

	@Override
	public void printInfo(TaskManager mgr, TaskJob job, TaskLogType type, String msg, boolean success) {
		String task = job==null ? "Master" : job.getName();
		logger.info(task + " [" + type.name() + "] ["+(success?"successful":"failed")+"] " + msg);
	}

	@Override
	public void printError(TaskManager mgr, TaskJob job, TaskLogType type, String msg, Exception e) {
		String task = job==null ? "Master" : job.getName();
		logger.error(task + " [" + type.name() + "] " + msg, e);
	}
	
	
	
	
	

}

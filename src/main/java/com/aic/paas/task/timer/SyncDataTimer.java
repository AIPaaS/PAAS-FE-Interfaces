package com.aic.paas.task.timer;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.msg.Message;
import com.aic.paas.task.msg.MessageFactory;
import com.aic.paas.task.msg.MsgType;
import com.binary.core.exception.MultipleException;
import com.binary.framework.Local;
import com.binary.framework.bean.Condition;
import com.binary.framework.bean.EntityBean;
import com.binary.framework.bean.User;
import com.binary.task.TaskJob;
import com.binary.task.TaskManager;
import com.binary.task.TaskStatus;
import com.binary.task.TaskType;

public class SyncDataTimer implements TaskJob {
	private static Logger logger = LoggerFactory.getLogger(SyncDataTimer.class);
	
	
	@Autowired
	MessageFactory messageFactory;
	

	
	private TaskType taskType;
	private String expression;
	
	
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
	
	@Override
	public String getName() {
		return SyncDataTimer.class.getName();
	}

	
	@Override
	public TaskType getTaskType() {
		return taskType;
	}

	
	@Override
	public Date getStartTime() {
		return new Date();
	}
	

	@Override
	public Date getEndTime() {
		return null;
	}

	
	@Override
	public String getExpression() {
		return this.expression;
	}

	
	@Override
	public Integer getRetryCount() {
		return null;
	}

	
	@Override
	public void saveLastRunTime(Date date) {
	}

	
	@Override
	public Date getLastRunTime() {
		return null;
	}
	
	

	@Override
	public void addRunnedCount() {
	}
	
	

	@Override
	public Integer getRunnedCount() {
		return null;
	}

	
	@Override
	public void setNextRunTime(Date nextTime) {
	}

	
	
	@Override
	public void updateTaskStatus(TaskStatus status) {
	}
	
	
	
	

	@Override
	public void run(TaskManager mgr, String jobId) {
		try {
			Local.open((User)null);
			
			Map<MsgType, Message<EntityBean,Condition>> map = messageFactory.getAllMessage();
			Iterator<Message<EntityBean,Condition>> itor = map.values().iterator();
			MultipleException me = new MultipleException();
			
			try {
				while(itor.hasNext()) {
					Message<EntityBean,Condition> msg = itor.next();
					msg.sendMssageBySync();
				}
			}catch(Throwable t) {
				me.add(t);
			}
			if(me.size() > 0) throw me;
			
			Local.commit();
		}catch(Throwable t) {
			Local.rollback();
			logger.error(" sync data error! ", t);
		}finally {
			Local.close();
		}
	}
	
	

}

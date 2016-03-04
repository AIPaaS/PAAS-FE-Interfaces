package com.aic.paas.task.mvc.msmq;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.msg.MsgType;
import com.aic.paas.task.svc.msmq.MessageTriggerSvc;
import com.binary.core.lang.Conver;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.framework.util.ControllerUtils;


@Controller
@RequestMapping("/msmq/trigger")
public class MessageTriggerMvc {
	
	
	@Autowired
	MessageTriggerSvc messageTriggerSvc;
	
	
	
	/**
	 * 指定日期触发消息
	 * @param type 对应消息代码
	 * @param date 格式：yyyyMMdd
	 */
	@RequestMapping("/wids")
	public void wids(HttpServletRequest request,HttpServletResponse response, String type, String ids) {
		BinaryUtils.checkEmpty(type, "type");
		BinaryUtils.checkEmpty(ids, "ids");
		Long[] arr = null;
		try {
			arr = Conver.to(ids.trim().split(","), Long.class);
		}catch(Exception e) {
			throw new ServiceException(" is wrong ids '"+ids+"'! ");
		}
		messageTriggerSvc.sendMessageByIds(MsgType.valueOf(type), arr);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	/**
	 * 指定日期触发消息
	 * @param type 对应消息代码
	 * @param date 格式：yyyyMMdd
	 */
	@RequestMapping("/wdate")
	public void wdate(HttpServletRequest request,HttpServletResponse response, String type, Integer date) {
		BinaryUtils.checkEmpty(type, "type");
		messageTriggerSvc.sendMessageByDate(MsgType.valueOf(type), date);
		ControllerUtils.returnJson(request, response, true);
	}
	

	
	/**
	 * 指定时间区间触发消息
	 * @param type 对应消息代码
	 * @param startTime 起始时间，毫秒数
	 * @param endTime 截止时间，毫秒数
	 */
	@RequestMapping("/wtinterval")
	public void wtinterval(HttpServletRequest request,HttpServletResponse response, String type, Long startTime, Long endTime) {
		BinaryUtils.checkEmpty(type, "type");
		BinaryUtils.checkEmpty(startTime, "startTime");
		BinaryUtils.checkEmpty(endTime, "endTime");
		
		Long start = BinaryUtils.getNumberDateTime(new Date(startTime));
		Long end = BinaryUtils.getNumberDateTime(new Date(endTime));
		messageTriggerSvc.sendMessageByTimeInterval(MsgType.valueOf(type), start, end);
		ControllerUtils.returnJson(request, response, true);
	}
	
	

	
	
	/**
	 * 触发发送所有消息
	 * @param type 对应消息代码
	 */
	@RequestMapping("/all")
	public void all(HttpServletRequest request,HttpServletResponse response, String type) {
		BinaryUtils.checkEmpty(type, "type");
		messageTriggerSvc.sendAllMessage(MsgType.valueOf(type));
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	
	
	
}

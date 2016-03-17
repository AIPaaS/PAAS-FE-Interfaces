package com.aic.paas.task.dep.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.dep.bean.CPcAppTask;
import com.aic.paas.task.dep.bean.PcAppTask;
import com.aic.paas.task.dep.peer.PcAppImagePeer;
import com.aic.paas.task.dep.rest.PcAppTaskSvc;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/dep")
public class PcAppLogMvc {

	@Autowired
	PcAppTaskSvc pcAppTaskSvc;

	@Autowired
	PcAppImagePeer pcAppImagePeer;

	@RequestMapping("/logs/query")
	public void queryLogs(HttpServletRequest request, HttpServletResponse response, Integer pageNum, Integer pageSize, Long appId) {
		CPcAppTask cPcAppTask = new CPcAppTask();
		cPcAppTask.setAppId(appId);
		Page<PcAppTask> page = pcAppTaskSvc.queryPage(pageNum, pageSize, cPcAppTask, "taskStartTime desc");
		ControllerUtils.returnJson(request, response, page);
	}

	@RequestMapping("/log/query")
	public void queryLog(HttpServletRequest request, HttpServletResponse response, Long appId, Long reqId, Long lastTime) {
		String resp = pcAppImagePeer.fetchLog(appId, reqId, lastTime);
		ControllerUtils.returnJson(request, response, resp);
	}
	
	@RequestMapping("/log/status")
	public void queryStatus(HttpServletRequest request, HttpServletResponse response, Long appId) {
		String resp = pcAppImagePeer.appStatus(appId);
		ControllerUtils.returnJson(request, response, resp);
	}
	
	@RequestMapping("/log/timer/status")
	public void queryTimerStatus(HttpServletRequest request, HttpServletResponse response, Long appId) {
		String resp = pcAppImagePeer.appTimerStatus(appId);
		ControllerUtils.returnJson(request, response, resp);
	}
}

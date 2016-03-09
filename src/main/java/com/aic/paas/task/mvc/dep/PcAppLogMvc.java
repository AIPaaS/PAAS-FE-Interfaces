package com.aic.paas.task.mvc.dep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.bean.dep.CPcAppTask;
import com.aic.paas.task.bean.dep.PcAppTask;
import com.aic.paas.task.peer.dep.PcAppImagePeer;
import com.aic.paas.task.rest.dep.PcAppTaskSvc;
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
	}

	@RequestMapping("/log/query")
	public void queryLog(HttpServletRequest request, HttpServletResponse response, Long appId, Long reqId, Long lastTime) {
		String resp = pcAppImagePeer.fetchLog(appId, reqId, lastTime);
		ControllerUtils.returnJson(request, response, resp);
	}

}

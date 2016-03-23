package com.aic.paas.task.mvc.res;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.peer.res.PcResManagePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.json.JSON;

@Controller
@RequestMapping("/res/manage")
public class PcResManageMvc {

	@Autowired
	PcResManagePeer pcResManagePeer;

	/**
	 * 资源环境部署的日志查询
	 * @param clusterId
	 */
	@RequestMapping("/queryLog")
	public void queryLog(HttpServletRequest request, HttpServletResponse response, Long id) {
		BinaryUtils.checkEmpty(id, "id");
		String logs = pcResManagePeer.queryLog(id);
		ControllerUtils.returnJson(request, response, JSON.toObject(logs));
	}
}

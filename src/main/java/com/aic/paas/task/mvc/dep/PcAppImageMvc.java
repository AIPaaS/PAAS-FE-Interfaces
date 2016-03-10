package com.aic.paas.task.mvc.dep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.peer.dep.PcAppImagePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;

@Controller
@RequestMapping("/dep/appimage")
public class PcAppImageMvc {
	static final Logger logger = LoggerFactory.getLogger(PcAppImageMvc.class);

	@Autowired
	PcAppImagePeer appImagePeer;

	/**
	 * 开始部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/startDeploy")
	public void startDeploy(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		logger.debug("===================== appId : " + appId);
		logger.debug("===================== appVnoId : " + appVnoId);
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		String resp = appImagePeer.startDeploy(appId, appVnoId);
		ControllerUtils.returnJson(request, response, resp);
	}

	/**
	 * 重新部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/reDeploy")
	public void reDeploy(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		logger.debug("===================== appId : " + appId);
		logger.debug("===================== appVnoId : " + appVnoId);
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		String resp = appImagePeer.reDeploy(appId, appVnoId);
		ControllerUtils.returnJson(request, response, resp);
	}

	/**
	 * 销毁部署
	 * 
	 * @param appId
	 */
	@RequestMapping("/stopDeploy")
	public void stopDeploy(HttpServletRequest request, HttpServletResponse response, Long appId) {
		BinaryUtils.checkEmpty(appId, "appId");
		String resp = appImagePeer.destroyDeploy(appId);
		ControllerUtils.returnJson(request, response, resp);
	}

	/**
	 * 开始运行app
	 * 
	 * @param appId
	 */
	@RequestMapping("/startApp")
	public void start(HttpServletRequest request, HttpServletResponse response, Long appId) {
		BinaryUtils.checkEmpty(appId, "appId");
		String resp = appImagePeer.startApp(appId);
		ControllerUtils.returnJson(request, response, resp);
	}

	/**
	 * 暂停运行app
	 * 
	 * @param appId
	 */
	@RequestMapping("/pauseApp")
	public void pause(HttpServletRequest request, HttpServletResponse response, Long appId) {
		BinaryUtils.checkEmpty(appId, "appId");
		String resp = appImagePeer.pauseApp(appId);
		ControllerUtils.returnJson(request, response, resp);
	}

}

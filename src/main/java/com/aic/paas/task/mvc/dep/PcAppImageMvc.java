package com.aic.paas.task.mvc.dep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.peer.dep.PcAppImagePeer;
import com.binary.core.util.BinaryUtils;

@Controller
@RequestMapping("/dep/appimage")
public class PcAppImageMvc {

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

		System.out.println("===================== appId : " + appId);
		System.out.println("===================== appVnoId : " + appVnoId);

		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		appImagePeer.startDeploy(appId, appVnoId);
	}

	/**
	 * 重新部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/reDeploy")
	public void reDeploy(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		appImagePeer.reDeploy(appId, appVnoId);
	}

	/**
	 * 停止部署
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/stopDeploy")
	public void stopDeploy(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		appImagePeer.destroyDeploy(appId, appVnoId);
	}

	/**
	 * 开始运行app
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/startApp")
	public void start(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		appImagePeer.startApp(appId, appVnoId);
	}

	/**
	 * 暂停运行app
	 * 
	 * @param appId
	 * @param appVnoId
	 */
	@RequestMapping("/pauseApp")
	public void pause(HttpServletRequest request, HttpServletResponse response, Long appId, Long appVnoId) {
		BinaryUtils.checkEmpty(appId, "appId");
		BinaryUtils.checkEmpty(appVnoId, "appVnoId");
		appImagePeer.pauseApp(appId, appVnoId);
	}

}

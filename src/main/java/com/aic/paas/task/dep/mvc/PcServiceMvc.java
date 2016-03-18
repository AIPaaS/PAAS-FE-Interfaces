package com.aic.paas.task.dep.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.dep.peer.PcServicePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;

@Controller
@RequestMapping("/interface/dep/service")
public class PcServiceMvc {
	static final Logger logger = LoggerFactory.getLogger(PcServiceMvc.class);
	@Autowired
	PcServicePeer pcServicePeer;
	
	
	/**
	 * register to consul
	 * 
	 * @param record  PcService
	 */
	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response, String record) {
		logger.debug("register to consul===================== record : " + record);
		BinaryUtils.checkEmpty(record, "record");
		pcServicePeer.register(record);
		ControllerUtils.returnJson(request, response, "");
	}
	
	
	/**
	 * deregister from consul
	 * 
	 * @param record  PcService
	 */
	@RequestMapping("/deregister")
	public void deregister(HttpServletRequest request, HttpServletResponse response, String record) {
		logger.debug("deregister from consul===================== record : " + record);
		BinaryUtils.checkEmpty(record, "record");
		pcServicePeer.deregister(record);
		ControllerUtils.returnJson(request, response, "");
	}
	
	
}

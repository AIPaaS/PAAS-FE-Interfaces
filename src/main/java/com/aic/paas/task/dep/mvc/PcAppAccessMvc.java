package com.aic.paas.task.dep.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.task.dep.peer.PcAppAccessPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;

@Controller
@RequestMapping("/interface/dep/appaccess")
public class PcAppAccessMvc {
	static final Logger logger = LoggerFactory.getLogger(PcAppAccessMvc.class);
	@Autowired
	PcAppAccessPeer pcAppAccessPeer;
	
	
	/**
	 * 新增或修改远端haproxy.cf配置信息
	 * 
	 * @param record  PcAppAccess
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, String record) {
		logger.debug("modify haproxy.cfg===================== record : " + record);
		BinaryUtils.checkEmpty(record, "record");
		ControllerUtils.returnJson(request, response, pcAppAccessPeer.saveOrUpdate(record));
	}
	
	
	/**
	 * 删除远端haproxy.cf配置信息
	 * 
	 * @param record  PcAppAccess
	 */
	@RequestMapping("/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response, String record) {
		logger.debug("modify haproxy.cfg===================== record : " + record);
		BinaryUtils.checkEmpty(record, "record");
		ControllerUtils.returnJson(request, response, pcAppAccessPeer.remove(record));
	}
	
	
	/**
	 * 新增或修改远端haproxy.cf配置信息
	 * 通过容器定义--触发
	 * @param record  PcAppImage
	 */
	@RequestMapping("/img/modfiy")
	public void addByImg(HttpServletRequest request, HttpServletResponse response, String record) {
		logger.debug("modify haproxy.cfg===================== record : " + record);
		BinaryUtils.checkEmpty(record, "record");
		ControllerUtils.returnJson(request, response, pcAppAccessPeer.saveOrUpdateByImg(record));
	}
	
	
	
}

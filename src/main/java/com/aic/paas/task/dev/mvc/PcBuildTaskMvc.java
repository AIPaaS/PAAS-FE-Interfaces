package com.aic.paas.task.dev.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;
import com.aic.paas.task.dev.bean.PcBuildTaskResponse;
import com.aic.paas.task.dev.peer.PcBuildTaskPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.json.JSON;
import com.binary.json.JSONObject;

@Controller
@RequestMapping("/dev/buildTaskMvc")
public class PcBuildTaskMvc {

	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskMvc.class);

	@Autowired
	PcBuildTaskPeer buildTaskPeer;

	/**
	 * aic.tsd_hyh 2016.03.14 构建中止，掉对方接口
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "stopBuilding")
	@ResponseBody
	public String post(@RequestBody String param) {
		System.out.println(param);

		String req = buildTaskPeer.stopPcBuildTaskApi(param);
		return req;

		// HttpClientUtil.sendPostRequest
		// DemoResponse deresp = new DemoResponse();
		// deresp.setNamespace("update");
		// deresp.setStatus("success"); // "status": "aborted", //error 为不存在此构建
		// return JSON.toString(deresp);
	}

	@RequestMapping("/queryTaskRecord")
	@ResponseBody
	public String queryTaskRecord(@RequestBody String param) throws Exception {
		BinaryUtils.checkEmpty(param, "param");
		JSONObject data = new JSONObject(param);
		String repo_name = data.getString("repo_name");
		String namespace = data.getString("namespace");
		String build_id = data.getString("build_id");
		return buildTaskPeer.queryTaskRecord(namespace, repo_name, build_id);


	}
	@RequestMapping(value="saveBuildTask")
	@ResponseBody
	public String saveBuildTask(@RequestBody String param) {		
		
		System.out.println("--------------------------------------------");
		System.out.println(param);
		String result = buildTaskPeer.saveBuildTask(param);
		
		//业务逻辑处理		
		PcBuildTaskResponse pbtr = new PcBuildTaskResponse();
		pbtr = JSON.toObject(result, PcBuildTaskResponse.class);

		return JSON.toString(pbtr);		
		
		
	}
	@RequestMapping(value="updateBuildTaskByCallBack")
	@ResponseBody
	public String updateBuildTaskByCallBack(@RequestBody String param){
		System.out.println("param =========================="+param);
		PcBuildTaskCallBack pbtc = new PcBuildTaskCallBack();
		pbtc = JSON.toObject(param, PcBuildTaskCallBack.class);
		String repo_nameTmp="/"+pbtc.getRepo_name();
		pbtc.setRepo_name(repo_nameTmp);
		String result ="";
		try {
			result = buildTaskPeer.updateBuildTaskByCallBack(pbtc);
		} catch (Exception e) {
			result = "error";
		}
		
		return result;
	}
	
	
	
	
	
	
	
}

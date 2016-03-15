package com.aic.paas.task.mvc.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aic.paas.task.peer.dev.PcBuildTaskPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.json.JSONObject;

@Controller
@RequestMapping("/dev/buildTaskMvc")
public class PcBuildTaskMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskMvc.class);
	
	@Autowired
	PcBuildTaskPeer buildTaskPeer ;
	
	
	/**
	 * aic.tsd_hyh  2016.03.14
	 * 构建中止，掉对方接口
	 * @param param
	 * @return
	 */
	@RequestMapping(value="stopBuilding")
	@ResponseBody
	public String post(@RequestBody String param) {		
		System.out.println(param);
		
		String req = buildTaskPeer.stopPcBuildTaskApi(param);
		return req;
		
		//HttpClientUtil.sendPostRequest
		//DemoResponse deresp = new DemoResponse();		
		//deresp.setNamespace("update");
		//deresp.setStatus("success");  // "status": "success", //error
		//return JSON.toString(deresp);		
	}
	
	
	
	@RequestMapping("/queryTaskRecord")
	@ResponseBody
	public String queryTaskRecord(@RequestBody String param) {
		BinaryUtils.checkEmpty(param, "param");
		JSONObject data = new JSONObject(param);
		String repo_name = data.getString("repo_name");
		String namespace = data.getString("namespace");
		String build_id = data.getString("build_id");
		JSONObject resultInfo=new JSONObject();
		resultInfo.put("namespace", "asiainfo");
		resultInfo.put("repo_name", repo_name);
		resultInfo.put("build_id", build_id);
		resultInfo.put("building", false);
		resultInfo.put("duration", 8);
		resultInfo.put("started_at", "2015-09-02T08:17:42.581Z");
		resultInfo.put("status", "success");
		resultInfo.put("stdout", "Started by user admin "
				+ "Building in workspace /var/jenkins_home/workspace/test\r\n"
				+ "[test] $ /bin/sh -xe /tmp/hudson7038042263921764692.sh\r\n"
				+ " echo /var/jenkins_home/workspace/test\r\n"
				+ "/var/jenkins_home/workspace/test\r\n"
				+ "Notifying upstream projects of job completion\r\n"
				+ "Finished: SUCCESS");
		return resultInfo.toString();

	}
	
	
	

}

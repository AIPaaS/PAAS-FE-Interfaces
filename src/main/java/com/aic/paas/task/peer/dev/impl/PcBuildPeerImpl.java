package com.aic.paas.task.peer.dev.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.mvc.dev.bean.PcBuildResponse;
import com.aic.paas.task.peer.dev.PcBuildPeer;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;
import com.binary.json.JSONObject;

public class PcBuildPeerImpl implements PcBuildPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildPeerImpl.class);

	private String buildManagementUrl;
	public void setBuildManagementUrl(String buildManagementUrl) {
		if(buildManagementUrl != null) {
			this.buildManagementUrl = buildManagementUrl.trim();
		}
	}
	
	//@Autowired
	//PcAppImageSvc appImageSvc;

	
	@Override
	public String removePcBuildApi(String param) {
		
		String url = buildManagementUrl+"/v1/builds";
		String rpc = HttpClientUtil.sendDeleteRequest(url, param);
		PcBuildResponse buildRes = JSON.toObject(rpc, PcBuildResponse.class);
		//return buildRes.getStatus();
		return "success";
	}
	
	@Override
	public String queryTaskRecord(String namespace, String repo_name, String build_id) {
		JSONObject result=new JSONObject();
		StringBuffer buffer=new StringBuffer();
		buffer.append("namespace={").append(namespace).append("}")
			  .append("&repo_name={").append(repo_name).append("}")
			  .append("&build_id={").append(build_id).append("}");
		String data = HttpClientUtil.sendGetRequest(buildManagementUrl+"/v1/builds", buffer.toString());//TODO 接口;
		if(data!=null&&!data.equals("")){
			result.put("error_code","999999");
			return result.toString();
		}
		return data;
	}

	

}

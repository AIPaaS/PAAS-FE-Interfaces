package com.aic.paas.task.peer.dev.impl;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.mvc.dev.bean.PcBuildResponse;
import com.aic.paas.task.peer.dev.PcBuildTaskPeer;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;
import com.binary.json.JSONObject;

public class PcBuildTaskPeerImpl implements PcBuildTaskPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskPeerImpl.class);

	private String buildManagementUrl;

	public void setBuildManagementUrl(String buildManagementUrl) {
		if (buildManagementUrl != null) {
			this.buildManagementUrl = buildManagementUrl.trim();
		}
	}

	// @Autowired
	// PcAppImageSvc appImageSvc;

	@Override
	public String stopPcBuildTaskApi(String params) {
		
		String url = buildManagementUrl+"/v1/builds"+"?"+params;
		String  param ="";
		/*try {
			param = java.net.URLEncoder.encode(params,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}   */
		String rpc = HttpClientUtil.sendDeleteRequest(url, param);//build_id=123456&namespace=SSS&repo_name=test2
		PcBuildResponse buildRes = JSON.toObject(rpc, PcBuildResponse.class);
		return buildRes.getStatus();
		//return "aborted";
	}

	@Override
	public String queryTaskRecord(String namespace, String repo_name, String build_id) throws Exception {
		JSONObject result = new JSONObject();
		StringBuffer buffer = new StringBuffer();
		buffer.append("namespace=").append(namespace).append("&repo_name=").append(repo_name).append("&build_id=")
				.append(build_id);
		String data = HttpClientUtil.sendGet(buildManagementUrl + "/v1/builds", buffer.toString());// TODO
																									// 接口;
		if (data == null || data.equals("")) {
			result.put("error_code", "999999");
			return result.toString();
		}
		return data;
	}

}

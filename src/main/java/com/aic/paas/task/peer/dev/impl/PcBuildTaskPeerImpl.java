package com.aic.paas.task.peer.dev.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.task.bean.dep.CPcImageRepository;
import com.aic.paas.task.bean.dep.PcImageRepository;
import com.aic.paas.task.bean.sys.CWsMerchent;
import com.aic.paas.task.bean.sys.WsMerchent;
import com.aic.paas.task.mvc.dev.bean.PcBuildResponse;
import com.aic.paas.task.mvc.dev.bean.PcBuildTaskCallBack;
import com.aic.paas.task.peer.dev.PcBuildTaskPeer;
import com.aic.paas.task.rest.dep.PcImageRepositorySvc;
import com.aic.paas.task.rest.dev.PcBuildSvc;
import com.aic.paas.task.rest.dev.PcBuildTaskSvc;
import com.aic.paas.task.rest.sys.MerchentSvc;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;
import com.binary.json.JSONObject;

public class PcBuildTaskPeerImpl implements PcBuildTaskPeer {

	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskPeerImpl.class);
	@Autowired
	PcBuildTaskSvc buildTaskSvc;
	
	@Autowired
	MerchentSvc merchentSvc;
	
	@Autowired
	PcBuildSvc buildSvc;
	
	@Autowired
	PcImageRepositorySvc imageRepositorySvc;
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

	@Override
	public String updateBuildTaskByCallBack(PcBuildTaskCallBack pbtc){
		
		List<WsMerchent> list = new ArrayList<WsMerchent>();
		CWsMerchent cdt = new  CWsMerchent();
		cdt.setMntCodeEqual(pbtc.getNamespace());
		cdt.setStatus(1);//0=待审核  1=审核通过  2=审核退回
		cdt.setDataStatus(1);//数据状态：1-正常 0-删除
		list = merchentSvc.queryList(cdt, null);
		//1.根据租户code namespace[mnt_code]，获取租户id mnt_id []
		if(list!=null && list.size()>0){
			pbtc.setMnt_id(list.get(0).getId().toString());
		}
		//2.根据	根据回调函数，查询所属机房的Id
		String compRoomId = buildSvc.queryCompRoomIdByCallBack(pbtc);
		//3.根据机房Id，查询镜像库Id
		CPcImageRepository cir = new CPcImageRepository();
		cir.setRoomId(Long.parseLong(compRoomId));
//		cir.setRoomId(Long.parseLong("74"));
		cir.setImgRespType(1);//imgRespType=1(是否快照镜像库)
		cir.setDataStatus(1);
		
		List<PcImageRepository> pirlist =imageRepositorySvc.queryList(cir, "ID");
		
		String imgRespId = "";//所属镜像库
		if(pirlist != null && pirlist.size()>0){
			if(pirlist.get(0).getId()!=null)imgRespId = pirlist.get(0).getId().toString();
		}
		
		return buildTaskSvc.updateBuildTaskByCallBack(pbtc,imgRespId);
	}

}

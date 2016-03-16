package com.aic.paas.task.test.svc;

import com.aic.paas.task.mvc.dev.bean.PcBuildTaskCallBack;
import com.aic.paas.task.mvc.dev.bean.PcBuildTaskRequest;
import com.aic.paas.task.mvc.dev.bean.PcBuildTaskResponse;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;


public class PcBuildTaskMvcTest {
	
	
	public static void main(String[] args) {
		String ppppp="{\"namespace\":\"SSS\",\"repo_name\":\"/aic/aic_one/aaa\",\"tag\":\"1.1.1\",\"build_id\":\"2\",\"duration\":\"8\",\"time\":\"2016-3-12 09:53:07.792\",\"status\":\"success\"}";
		
		PcBuildTaskCallBack pbtc = new PcBuildTaskCallBack();
		
		pbtc.setNamespace("SSS");
		pbtc.setRepo_name("/aic/aic_one/aaa");
		pbtc.setBuild_id("2");
		pbtc.setDuration("8");
		pbtc.setTag("1.1.1");
		pbtc.setTime("2016-3-12 09:53:07.792");
		pbtc.setStatus("success");
		String param1 = JSON.toString(pbtc);
		
		String sendPostRequest = HttpClientUtil.sendPostRequest("http://localhost:16009/paas-task/dev/buildTaskMvc/updateBuildTaskByCallBack", param1);
//		String sendPostRequest = HttpClientUtil.sendPostRequest("http://10.1.245.100:16009/paas-task/dev/buildTaskMvc/updateBuildTaskByCallBack", param1);
		
		System.out.println("------------------"+sendPostRequest);
		
	}
}

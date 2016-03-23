package com.aic.paas.task.test.svc;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;
import com.aic.paas.task.dev.bean.PcBuildTaskRequest;
import com.aic.paas.task.dev.bean.PcBuildTaskResponse;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;


public class PcBuildTaskMvcTest {
	
	
	public static void main(String[] args) {
//		String ppppp="{\"namespace\":\"SSS\",\"repo_name\":\"/aic/aic_one/aaa\",\"tag\":\"1.1.1\",\"build_id\":\"2\",\"duration\":\"8\",\"time\":\"2016-3-12 09:53:07.792\",\"status\":\"success\"}";
//{"repo_name":"paas_web/paas_task/aaaaa","image_name":"paas_task/paas_task/1.1","tag":"1.1.1","callback_url":"http://localhost:16203/paas-wdev/dev/buildTaskMvc/updateBuildTaskByCallBack","namespace":"aaa_____renfeng3"}
		PcBuildTaskCallBack pbtc = new PcBuildTaskCallBack();
		
		pbtc.setNamespace("aaa_____zhaolijing");
		pbtc.setRepo_name("paas/paasproject/buildname");
		pbtc.setBuild_id("33");
		pbtc.setDuration("8");
		pbtc.setTag("1.1.1");
		pbtc.setTime("2016-3-20 17:53:07.792");
		pbtc.setStatus("success");
		String param1 = JSON.toString(pbtc);
		System.out.println(param1);
		
//		String param11="{\"duration\":\"8\",\"time\":\"2016-3-12 09:53:07.792\",\"repo_name\":\"paas_dubbo/paas_dubbo2/ooooo\",\"status\":\"success\",\"tag\":\"1.1.1\",\"build_id\":\"1\",\"namespace\":\"aaa_____renfeng3\"}";
//		String sendPostRequest = HttpClientUtil.sendPostRequest("http://10.1.245.248:16009/paas-task/dev/buildTaskMvc/updateBuildTaskByCallBack", param1);
		String sendPostRequest = HttpClientUtil.sendPostRequest("http://localhost:16009/paas-task/dev/buildTaskMvc/updateBuildTaskByCallBack", param1);
		
		System.out.println("------------------"+sendPostRequest);
		
	}
}

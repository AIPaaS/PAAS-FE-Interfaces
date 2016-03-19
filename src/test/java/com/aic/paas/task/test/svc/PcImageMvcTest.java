package com.aic.paas.task.test.svc;

import java.util.HashMap;
import java.util.Map;

import com.aic.paas.task.dev.bean.PcBuildTaskCallBack;
import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;


public class PcImageMvcTest {
	
	
	public static void main(String[] args) {
		Map<String,String> callBackMap = new HashMap<String,String>();
		callBackMap.put("image_name", "paas_task/paas_task-1.1");
		callBackMap.put("tag", "9.9.9");
		callBackMap.put("time", "2016-03-19 11:32:56.816028");
		callBackMap.put("status", "success");// success / error
		callBackMap.put("build_id","136");
		String param1 = JSON.toString(callBackMap);
		System.out.println(param1);
		
//		String sendPostRequest = HttpClientUtil.sendPostRequest("http://localhost:16009/paas-task/dev/imageMvc/updateImageByCallBack", param1);
		String sendPostRequest = HttpClientUtil.sendPostRequest("http://10.1.245.100:16009/paas-task/dev/imageMvc/updateImageByCallBack", param1);
		
		System.out.println("------------------"+sendPostRequest);
		
	}
}

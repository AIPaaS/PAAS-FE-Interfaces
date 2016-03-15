package com.aic.paas.task.mvc.dev;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.util.http.HttpClientUtil;
import com.binary.json.JSON;

@Controller
@RequestMapping("/dev/buildDefMvc")
public class PcBuildDefMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildDefMvc.class);
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="buildDefApi")
	public @ResponseBody String buildDefApi(@RequestBody String param) {	
		String result = HttpClientUtil.sendPostRequest("http://10.1.245.139:8088/v1/repositories", param);
		if(result!=null&&!"".equals(result)){
			Map<String,String> map = JSON.toObject(result, Map.class);
			return map.get("status");
		}else{
			return "error";
		}
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="updateBuildDefApi")
	public @ResponseBody String updateBuildDefApi(@RequestBody String param) {	
		String result = HttpClientUtil.sendPutRequest("http://10.1.245.139:8088/v1/repositories", param);
		if(result!=null&&!"".equals(result)){
			Map<String,String> map = JSON.toObject(result, Map.class);
			return map.get("status");
		}else{
			return "error";
		}
	}
	
	

}

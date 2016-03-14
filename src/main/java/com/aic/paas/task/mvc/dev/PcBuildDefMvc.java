package com.aic.paas.task.mvc.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.mvc.dev.bean.DemoResponse;

@Controller
@RequestMapping("/dev/buildDefMvc")
public class PcBuildDefMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildDefMvc.class);
	
	@RequestMapping(value="buildDefApi")
	public @ResponseBody String buildDefApi(String param) {	
		
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		deresp.setNamespace("post");
		
		return "000000";		
		
		
	}
	

}

package com.aic.paas.task.mvc.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.mvc.dev.bean.DemoResponse;
import com.binary.json.JSON;

@Controller
@RequestMapping("/dev/buildTaskMvc")
public class PcBuildTaskMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildTaskMvc.class);
	
	@RequestMapping(value="update")
	@ResponseBody
	public String post(@RequestBody String param) {		
		
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		deresp.setNamespace("post");
		
		return JSON.toString(deresp);		
		
		
	}
	
	
	
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(@RequestBody String param) {	
	
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		deresp.setNamespace("delete");
		return JSON.toString(deresp);		
	}
	
	
	

}

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
@RequestMapping("/dev/buildMvc")
public class PcBuildMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildMvc.class);
	
	/*@RequestMapping(value="post")
	@ResponseBody
	public String post(@RequestBody String param) {		
		
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		deresp.setNamespace("post");
		
		return JSON.toString(deresp);		
		
		
	}*/
	
	
	
	/**
	 * aic.tsd_hyh  2016.03.14
	 * 删除构建定义，掉对方接口
	 * @param param
	 * @return
	 */
	@RequestMapping(value="deleteBuild")
	@ResponseBody
	public String delete(@RequestBody String param) {	
	
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		//deresp.setNamespace("deleteBuild");
		deresp.setStatus("success");  // "status": "success", //error
		return JSON.toString(deresp);		
	}
	
	
	/*@RequestMapping(value="put")
	@ResponseBody
	public String put(@RequestBody String param) {
		
		System.out.println("--------------------------------------------");
		System.out.println(param);
		
		//业务逻辑
		//异常处理
		
		DemoResponse deresp = new DemoResponse();		
		deresp.setNamespace("put");
		
		return JSON.toString(deresp);		
				
		
	}*/

}

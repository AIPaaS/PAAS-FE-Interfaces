package com.aic.paas.task.dev.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.dev.peer.PcImagePeer;
import com.binary.json.JSON;

@Controller
@RequestMapping("/dev/imageMvc")
public class PcImageMvc {

	static final Logger logger = LoggerFactory.getLogger(PcImageMvc.class);

	@Autowired
	PcImagePeer imagePeer;

	@RequestMapping(value="uploadImage")
	@ResponseBody
	public String uploadImage(@RequestBody String param) {		
		
		System.out.println(param);
		String uploadResult = imagePeer.uploadImage(param);
		return uploadResult;		
		
		
	}
	@RequestMapping(value="updateImageByCallBack")
	@ResponseBody
	public String updateBuildTaskByCallBack(@RequestBody String param)throws Exception{
		System.out.println("param =========================="+param);
		
		String result ="error";
		try {
			result = imagePeer.updateImageByCallBack(param);
		} catch (Exception e) {

		}
		return result;
	}
	
	@RequestMapping(value="imageSyncApi")
	public @ResponseBody String imageSyncApi(@RequestBody String param) {	
		System.out.println("param====================="+param);
		return imagePeer.imageSyncApi(param);
	}
	
	@RequestMapping(value="imageSyncCallback")
	public @ResponseBody String imageSyncCallback(@RequestBody String param) {	
		System.out.println("param====================="+param);
		return imagePeer.imageSyncCallback(param);
	}
	
	
	
	
	
	
}

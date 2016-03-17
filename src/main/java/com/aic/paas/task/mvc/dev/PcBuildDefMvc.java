package com.aic.paas.task.mvc.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.task.peer.dev.PcBuildDefPeer;

@Controller
@RequestMapping("/dev/buildDefMvc")
public class PcBuildDefMvc {
	
	static final Logger logger = LoggerFactory.getLogger(PcBuildDefMvc.class);
	@Autowired
	private PcBuildDefPeer pcBuildDefPeer;

	@RequestMapping(value="buildDefApi")
	public @ResponseBody String buildDefApi(@RequestBody String param) {	
		return pcBuildDefPeer.buildDefApi(param);
	}
	@RequestMapping(value="updateBuildDefApi")
	public @ResponseBody String updateBuildDefApi(@RequestBody String param) {	
		return pcBuildDefPeer.updateBuildDefApi(param);
	}
	

}

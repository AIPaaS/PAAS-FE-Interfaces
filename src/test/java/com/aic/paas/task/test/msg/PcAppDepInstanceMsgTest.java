package com.aic.paas.task.test.msg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.aic.paas.task.dep.bean.CPcAppDepInstance;
import com.aic.paas.task.dep.bean.PcAppDepInstance;
import com.aic.paas.task.dep.msg.PcAppDepInstanceMsg;
import com.binary.framework.test.TestTemplate;

public class PcAppDepInstanceMsgTest extends TestTemplate {

	
	
	PcAppDepInstanceMsg msg;
	
	
	@Before
	public void init() {
		msg = getBean(PcAppDepInstanceMsg.class);
	}
	
	
	
	@Test
	public void queryList() {
		long pageNum = 1;
		long pageSize = 100;
		CPcAppDepInstance cdt = new CPcAppDepInstance();
		String orders = "";
		List<PcAppDepInstance> ls =  msg.queryList(pageNum, pageSize, cdt, orders);
		
		System.out.println("===================================================================");
		printList(ls);
	}
	
	
}

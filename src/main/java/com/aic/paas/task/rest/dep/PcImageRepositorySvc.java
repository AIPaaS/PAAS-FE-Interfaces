package com.aic.paas.task.rest.dep;
import java.util.List;

import com.aic.paas.task.bean.dep.CPcImageRepository;
import com.aic.paas.task.bean.dep.PcImageRepository;

public interface PcImageRepositorySvc {
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcImageRepository> queryList(CPcImageRepository cdt, String orders);
	
}
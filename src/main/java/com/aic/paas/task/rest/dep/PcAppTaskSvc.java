package com.aic.paas.task.rest.dep;

import com.aic.paas.task.bean.dep.CPcAppTask;
import com.aic.paas.task.bean.dep.PcAppTask;
import com.binary.jdbc.Page;

public interface PcAppTaskSvc {
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppTask数据记录
	 * @return 当前记录主键[id]值
	 */
	public void save(PcAppTask record);
	
//	public void update(PcAppTask record)
	
	public PcAppTask queryById(Long id);
	
	public Page<PcAppTask> queryPage(Integer pageNum, Integer pageSize, CPcAppTask cdt, String orders);
}

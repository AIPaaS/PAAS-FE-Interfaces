package com.aic.paas.task.rest.dep;

import com.aic.paas.task.bean.dep.PcAppDepInstance;

public interface PcAppDepInstanceSvc {
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : PcAppDepInstance数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcAppDepInstance record);
}

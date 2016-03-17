package com.aic.paas.task.dep.rest;

import java.util.List;

import com.aic.paas.task.dep.bean.CPcResCenter;
import com.aic.paas.task.dep.bean.PcResCenter;
import com.binary.jdbc.Page;

public interface PcResCenterSvc {

	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<PcResCenter> queryPage(Integer pageNum, Integer pageSize, CPcResCenter cdt, String orders);


	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcResCenter> queryPage2(Integer pageNum, Integer pageSize, CPcResCenter cdt, String orders);

	
	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<PcResCenter> queryList(CPcResCenter cdt, String orders);

	
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcResCenter queryById(Long id);
	
	
	
	
	
	
	
	
	
}

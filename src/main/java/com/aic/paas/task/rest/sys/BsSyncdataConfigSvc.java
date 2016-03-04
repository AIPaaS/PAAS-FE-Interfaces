package com.aic.paas.task.rest.sys;

import java.util.List;

import com.aic.paas.task.bean.sys.BsSyncdataConfig;
import com.aic.paas.task.bean.sys.CBsSyncdataConfig;
import com.binary.jdbc.Page;

public interface BsSyncdataConfigSvc {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_ORG]分页列表对象
	 */
	public Page<BsSyncdataConfig> queryPage(Integer pageNum, Integer pageSize, CBsSyncdataConfig cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_ORG]查询列表
	 */
	public List<BsSyncdataConfig> queryList(CBsSyncdataConfig cdt, String orders);
	
	
	
	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CBsSyncdataConfig cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_ORG]映射对象
	 */
	public BsSyncdataConfig queryById(Long id);
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysOp数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(BsSyncdataConfig record);
	
	
	
	
	
	

}

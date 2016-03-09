package com.aic.paas.task.rest.dep;

import java.util.List;

import com.aic.paas.task.bean.dep.CPcApp;
import com.aic.paas.task.bean.dep.CPcAppMgr;
import com.aic.paas.task.bean.dep.CPcAppVersion;
import com.aic.paas.task.bean.dep.PcApp;
import com.aic.paas.task.bean.dep.PcAppMgr;
import com.aic.paas.task.bean.dep.PcAppVersion;
import com.binary.jdbc.Page;

public interface PcAppSvc {

	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public Page<PcApp> queryPage(Integer pageNum, Integer pageSize, CPcApp cdt, String orders);

	/**
	 * 不分页查询
	 * 
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcApp> queryList(CPcApp cdt, String orders);

	/**
	 * 跟据主键查询
	 * 
	 * @param id
	 *            : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public PcApp queryById(Long id);

	/**
	 * 查询管理员所管理的应用
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public Page<PcApp> queryMgrPage(Integer pageNum, Integer pageSize, Long mgrId, CPcApp cdt, String orders);

	/**
	 * 查询管理员所管理的应用
	 * 
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcApp> queryMgrList(Long mgrId, CPcApp cdt, String orders);

	/**
	 * 查询管理员所管理的应用
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public Page<PcAppMgr> queryAppMgrPage(Integer pageNum, Integer pageSize, CPcAppMgr cdt, String orders);

	/**
	 * 查询管理员所管理的应用
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcAppMgr> queryAppMgrPage2(Integer pageNum, Integer pageSize, CPcAppMgr cdt, String orders);

	/**
	 * 查询管理员所管理的应用
	 * 
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcAppMgr> queryAppMgrList(CPcAppMgr cdt, String orders);

	/**
	 * 查询应用版本
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public Page<PcAppVersion> queryAppVersionPage(Integer pageNum, Integer pageSize, CPcAppVersion cdt, String orders);

	/**
	 * 查询应用版本
	 * 
	 * @param pageNum
	 *            : 指定页码
	 * @param pageSize
	 *            : 指定页行数
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcAppVersion> queryAppVersionPage2(Integer pageNum, Integer pageSize, CPcAppVersion cdt, String orders);

	/**
	 * 查询应用版本
	 * 
	 * @param cdt
	 *            : 条件对象
	 * @param orders
	 *            : 排序字段, 多字段以逗号分隔
	 * @return
	 */
	public List<PcAppVersion> queryAppVersionList(CPcAppVersion cdt, String orders);

	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * 
	 * @param record
	 *            : PcApp数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(PcApp record);

	/**
	 * 跟据分类ID删除
	 * 
	 * @param id
	 * @return
	 */
	public int removeById(Long id);

	/**
	 * 设置应用管理员
	 * 
	 * @param appId
	 * @param mgrIds
	 */
	public void setAppMgrs(Long appId, Long[] mgrIds);

}

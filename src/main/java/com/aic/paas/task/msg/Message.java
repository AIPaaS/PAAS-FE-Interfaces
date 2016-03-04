package com.aic.paas.task.msg;

import java.util.List;

import com.binary.framework.bean.Condition;
import com.binary.framework.bean.EntityBean;

public interface Message<E extends EntityBean, F extends Condition> {
	
	
	
	
	/**
	 * 获取消息类型
	 * @return
	 */
	public MsgType getType();
	
	
	
	
	/**
	 * 获取实体对象
	 * @return
	 */
	public Class<E> getEntityClass();
	
	
	
	
	/**
	 * 获取条件对象
	 * @return
	 */
	public Class<F> getConditionClass();
	
	
	
	
	/**
	 * 不带count分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段
	 * @return 
	 */
	public List<E> queryList(long pageNum, long pageSize, F cdt, String orders);


	
	
	
	/**
	 * 不带分页查询
	 * @param cdt 条件对象
	 * @param orders 排序字段
	 * @return
	 */
	public List<E> queryList(F cdt, String orders);
	
	
	
	
	
	
	/**
	 * 更新同步信息发送消息
	 */
	public void sendMssageBySync();
	
	
	
	
	/**
	 * 跟据条件发送消息, 如果条件为空则表示发送所有数据
	 * @param cdt
	 */
	public void sendMessageByCdt(F cdt);
	

	
	
	
	
}

package com.aic.paas.task.rest.sys;

import java.util.List;

import com.aic.paas.task.bean.sys.CWsMerchent;
import com.aic.paas.task.bean.sys.WsMerchent;


public interface MerchentSvc {
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<WsMerchent> queryList(CWsMerchent cdt, String orders);
}
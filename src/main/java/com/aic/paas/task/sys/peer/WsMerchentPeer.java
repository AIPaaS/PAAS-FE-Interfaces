package com.aic.paas.task.sys.peer;

import java.util.List;

import com.aic.paas.task.sys.bean.CWsMerchent;
import com.aic.paas.task.sys.bean.WsMerchent;

public interface WsMerchentPeer {

	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<WsMerchent> queryList(CWsMerchent cdt, String orders);
}

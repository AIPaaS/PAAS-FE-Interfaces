package com.aic.paas.task.util;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.binary.framework.dao.Dao;
import com.binary.framework.dao.DaoDefinition;
import com.binary.framework.dao.support.AbstractDao;

public abstract class TaskUtil {
	
	
	
	
	/**
	 * 替换所有DaoDefinition
	 * @param context
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void replaceAllDaoDefinition(ApplicationContext context) {
		Map<String, Dao> map = context.getBeansOfType(Dao.class);
		Iterator<Dao> itor = map.values().iterator();
		
		while(itor.hasNext()) {
			Dao dao = itor.next();
			DaoDefinition def = dao.getDaoDefinition();
			DaoDefinitionProxy proxy = new DaoDefinitionProxy(def);
			((AbstractDao)dao).setDaoDefinition(proxy);
		}
	}
	
	
	

}

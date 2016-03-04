package com.aic.paas.task.util;

import com.binary.framework.bean.Condition;
import com.binary.framework.bean.EntityBean;
import com.binary.framework.dao.DaoDefinition;


public class DaoDefinitionProxy<E extends EntityBean, F extends Condition> implements DaoDefinition<E,F> {

	
	private DaoDefinition<E,F> definition;
	
	
	public DaoDefinitionProxy(DaoDefinition<E,F> definition) {
		this.definition = definition;
	}
	
	
	
	
	@Override
	public String getTableName() {
		return this.definition.getTableName();
	}

	
	@Override
	public Class<E> getEntityClass() {
		return this.definition.getEntityClass();
	}
	
	

	@Override
	public Class<F> getConditionClass() {
		return definition.getConditionClass();
	}
	
	

	@Override
	public boolean hasDataStatusField() {
		return this.definition.hasDataStatusField();
	}
	
	
	
	@Override
	public void setDataStatusValue(E e, int value) {
		this.definition.setDataStatusValue(e, value);
	}

	
	@Override
	public void setDataStatusValue(F f, int value) {
		//去除查询时默认条件带上dataStatus
	}

	
	@Override
	public void setCreatorValue(E e, String creator) {
		this.definition.setCreatorValue(e, creator);
	}

	
	
	@Override
	public void setModifierValue(E e, String modifier) {
		this.definition.setModifierValue(e, modifier);
	}
	
	
	
	

}

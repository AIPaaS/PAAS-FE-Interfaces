package com.aic.paas.task.dep.rest;

import java.util.List;

import com.aic.paas.task.dep.bean.PcKvPair;

public interface PcKvPairSvc {
	
	public List<PcKvPair> getPcKvPairs(Long sourceId,Integer typeId);
}

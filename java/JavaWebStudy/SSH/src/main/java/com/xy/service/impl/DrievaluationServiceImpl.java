package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.DrievaluationDaoInter;
import com.xy.model.Drievaluation;
import com.xy.service.DrievaluationServiceInter;

@Service("drievaluationProxy")
public class DrievaluationServiceImpl extends BaseServiceImpl<Drievaluation> implements DrievaluationServiceInter {
	@Autowired
	private DrievaluationDaoInter dEvaDao;		//从容器中注入session工厂【无需get,set方法】
	
}

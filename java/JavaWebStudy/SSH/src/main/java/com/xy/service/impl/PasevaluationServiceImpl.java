package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.PasevaluationDaoInter;
import com.xy.model.Pasevaluation;
import com.xy.service.PasevaluationServiceInter;

@Service("pasevaluationProxy")
public class PasevaluationServiceImpl extends BaseServiceImpl<Pasevaluation>
		implements PasevaluationServiceInter {
	@Autowired
	private PasevaluationDaoInter pasEvDao;		//从容器中注入session工厂【无需get,set方法】
	
	
}

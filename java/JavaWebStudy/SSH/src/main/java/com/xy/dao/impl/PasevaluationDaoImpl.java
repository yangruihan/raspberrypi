package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.PasevaluationDaoInter;
import com.xy.model.Pasevaluation;

@Repository("pasevaluationDao")
public class PasevaluationDaoImpl extends BaseDaoImpl<Pasevaluation> implements
		PasevaluationDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public PasevaluationDaoImpl() {
		super(Pasevaluation.class);
	}
}

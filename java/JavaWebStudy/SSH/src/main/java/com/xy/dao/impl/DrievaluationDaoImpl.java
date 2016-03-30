package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.DrievaluationDaoInter;
import com.xy.model.Drievaluation;

@Repository("drievaluationDao")
public class DrievaluationDaoImpl extends BaseDaoImpl<Drievaluation> implements
		DrievaluationDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public DrievaluationDaoImpl() {
		super(Drievaluation.class);
	}
}

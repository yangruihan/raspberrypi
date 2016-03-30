package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.ComplainDaoInter;
import com.xy.model.Complain;

@Repository("complainDao")
public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements
		ComplainDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public ComplainDaoImpl() {
		super(Complain.class);
	}
}

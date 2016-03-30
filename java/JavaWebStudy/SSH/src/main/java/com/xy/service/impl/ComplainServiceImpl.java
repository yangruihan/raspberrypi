package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.ComplainDaoInter;
import com.xy.model.Complain;
import com.xy.service.ComplainServiceInter;

@Service("complainProxy")
public class ComplainServiceImpl extends BaseServiceImpl<Complain> implements
		ComplainServiceInter {
	@Autowired
	private ComplainDaoInter complainDao;		//从容器中注入session工厂【无需get,set方法】
	
}

package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.SharingConfirmDaoInter;
import com.xy.model.Sharingcarconfirm;

@Repository("sharingConfirmDao")
public class SharingConfirmDaoImp extends BaseDaoImpl<Sharingcarconfirm> implements SharingConfirmDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public SharingConfirmDaoImp() {
		super(Sharingcarconfirm.class);
	}
	
}

package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.SharingCarInfoDaoInter;
import com.xy.model.Sharingcarinfo;

@Repository("sharingCarInfoDao")
public class SharingCarInfoDaoImp extends BaseDaoImpl<Sharingcarinfo> implements SharingCarInfoDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public SharingCarInfoDaoImp() {
		super(Sharingcarinfo.class);
	}
	
}

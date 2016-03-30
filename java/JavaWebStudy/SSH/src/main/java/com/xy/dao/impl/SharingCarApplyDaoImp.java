package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.SharingCarApplyDaoInter;
import com.xy.model.Sharingcarapply;

@Repository("sharingCarApplyDao")
public class SharingCarApplyDaoImp extends BaseDaoImpl<Sharingcarapply> implements SharingCarApplyDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public SharingCarApplyDaoImp() {
		super(Sharingcarapply.class);
	}

}

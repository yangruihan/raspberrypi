package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.UserDaoInter;
import com.xy.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoInter{
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void addedFunction() {
		System.out.println("added function");
	}
	
}

package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.UserDaoInter;
import com.xy.model.User;
import com.xy.service.UserServiceInter;

@Service("userProxy")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserServiceInter{

	@Autowired
	private UserDaoInter userDao;			//从容器中注入session工厂【无需get,set方法】
	
	@Override
	public void transaction() {
		userDao.save(new User("11111111","xioingyu"));
		@SuppressWarnings("unused")
		int a = 0/0;
		userDao.save(new User("22222222","xioingyu"));
	}
	
}

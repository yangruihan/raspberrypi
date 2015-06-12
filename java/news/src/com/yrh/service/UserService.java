package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {
	
	private UserDao userDao = new UserDaolmpl();
	
	/**
	 * 用户注册
	 * @param user
	 * @return true 表示成功 false 表示失败
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException {
		if (!userDao.isExist(user.getName())) {
			if (userDao.add(user)) {
				System.out.println("添加成功");
				return true;
			} else {
				System.out.println("添加失败");
			}
		} else {
			System.out.println("用户名已存在");
		}
		return false;
	}
}

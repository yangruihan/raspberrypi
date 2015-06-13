package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {

	private static UserDao userDao = new UserDaolmpl();

	/**
	 * 用户注册
	 * @param user 用户实体
	 * @return true 表示成功 false 表示失败
	 * @throws AppException
	 */
	public static boolean register(User user) throws AppException {
		boolean flag = false;
		try {
			if (!userDao.isExist(user.getName())) {
				if (userDao.add(user)) {
					System.out.println("添加成功");
					flag = true;
				} else {
					System.out.println("添加失败");
				}
			} else {
				System.out.println("用户名已存在");
			}
		} catch (AppException e) {
			throw new AppException("com.yrh.service.UserService.register");
		}
		return flag;
	}
	
	/**
	 * 用户登录
	 * @param user 用户实体
	 * @return true 表示登录成功 false 表示登录失败
	 * @throws AppException
	 */
	public static boolean login(User user) throws AppException {
		boolean flag = false;
		if (userDao.check(user)) {
			System.out.println("登陆成功");
			flag = true;
		} else {
			System.out.println("用户名或密码错误");
		}
		return flag;
	}
	
}

package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {

	private static UserDao userDao = new UserDaolmpl();

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户实体
	 * @return true 表示成功 false 表示失败
	 * @throws AppException
	 */
	public static boolean register(User user) throws AppException {
		boolean flag = false;
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
		return flag;
	}
	
	/**
	 * 通过用户名密码登录
	 * @param name
	 * @param password
	 * @return true 表示登录成功 false 表示登录失败
	 * @throws AppException
	 */
	public static boolean login(String name, String password) throws AppException {
		boolean flag = false;
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		if (login(user)) {
			System.out.println("登录成功");
			flag = true;
		} else {
			System.out.println("用户名或密码错误");
		}
		return flag;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户实体
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

	/**
	 * 根据用户id返回用户身份信息
	 * 
	 * @param userid
	 *            用户id
	 * @return 用户身份信息（0 普通编辑 1 管理员）
	 * @throws AppException
	 */
	public static int getUserRole(int userid) throws AppException {
		int role;
		role = userDao.getRoleById(userid);
		System.out.println("用户身份为：" + role);
		return role;
	}

	/**
	 * 根据用户名返回用户身份信息
	 * 
	 * @param name
	 *            用户名
	 * @return 用户身份信息（0 普通编辑 1 管理员）
	 * @throws AppException
	 */
	public static int getUserRole(String name) throws AppException {
		int role;
		role = userDao.getRoleByName(name);
		System.out.println("用户身份为：" + role);
		return role;
	}

	/**
	 * 通过用户名获取用户id
	 * 
	 * @param name
	 *            用户名
	 * @return 用户id
	 * @throws AppException
	 */
	public static int getUserID(String name) throws AppException {
		int id;
		id = userDao.getIdByName(name);
		System.out.println("用户ID为：" + id);
		return id;
	}

}

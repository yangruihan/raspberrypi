package com.yrh.dao;

import com.yrh.model.User;
import com.yrh.utils.AppException;

public interface UserDao {

	/**
	 * 判断制定用户名的用户是否存在
	 * @param name 用户名
	 * @return true 表示已存在 false 表示不存在
	 * @throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	
	/**
	 * 保存用户注册信息
	 * @param user 用户对象
	 * @return true 表示保存成功 false 表示保存失败
	 * @throws AppException
	 */
	public boolean add(User user) throws AppException;
}

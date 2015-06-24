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
	
	/**
	 * 检查登录用户名或密码是否正确
	 * @param user 用户对象
	 * @return true 表示正确 false 表示错误
	 * @throws AppException
	 */
	public boolean check(User user) throws AppException;
	
	/**
	 * 通过用户id取得用户身份信息 
	 * @param userid 用户id
	 * @return 0 普通编辑 1 管理员
	 * @throws AppException
	 */
	public int getRoleById(int userid) throws AppException;
	
	/**
	 * 通过用户名得到用户身份信息
	 * @param name 用户名
	 * @return 0 普通编辑 1 管理员
	 * @throws AppException
	 */
	public int getRoleByName(String name) throws AppException;
	
	/**
	 * 通过用户名得到用户id
	 * @param name 用户名
	 * @return 用户id
	 * @throws AppException
	 */
	public int getIdByName(String name) throws AppException;
}

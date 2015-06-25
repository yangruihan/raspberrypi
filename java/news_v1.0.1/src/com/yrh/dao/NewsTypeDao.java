package com.yrh.dao;

import com.yrh.utils.AppException;

public interface NewsTypeDao {

	/**
	 * 获得新闻类型id
	 * @param name 新闻类型名
	 * @return 新闻类型id
	 * @throws AppException
	 */
	public int getIdByName(String name) throws AppException;
	
	/**
	 * 获得新闻类型名
	 * @param id 新闻id
	 * @return
	 * @throws AppException
	 */
	public String getNameById(int id) throws AppException;
	
	/**
	 * 获得新闻类型的总数
	 * @return
	 * @throws AppException
	 */
	public int getNewsTypeNumbers() throws AppException;
}

package com.yrh.service;

import com.yrh.dao.NewsTypeDao;
import com.yrh.dao.NewsTypeDaolmpl;
import com.yrh.utils.AppException;

public class NewsTypeService {

	private static NewsTypeDao newsTypeDao = new NewsTypeDaolmpl();

	/**
	 * ͨ��������������ȡ��������id
	 * 
	 * @param name
	 * @return
	 */
	public static int getNewsTypeId(String name) throws AppException {
		int id = 0;
		id = newsTypeDao.getIdByName(name);
		return id;
	}
	
	/**
	 * ͨ����������id�������������
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public static String getNewsTypeName(int id) throws AppException {
		String name = "";
		name = newsTypeDao.getNameById(id);
		return name;
	}
}

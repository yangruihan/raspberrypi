package com.yrh.dao;

import com.yrh.utils.AppException;

public interface NewsTypeDao {

	/**
	 * �����������id
	 * @param name ����������
	 * @return ��������id
	 * @throws AppException
	 */
	public int getIdByName(String name) throws AppException;
	
	/**
	 * �������������
	 * @param id ����id
	 * @return
	 * @throws AppException
	 */
	public String getNameById(int id) throws AppException;
	
	/**
	 * ����������͵�����
	 * @return
	 * @throws AppException
	 */
	public int getNewsTypeNumbers() throws AppException;
}

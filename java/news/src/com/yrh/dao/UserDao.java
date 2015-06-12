package com.yrh.dao;

import com.yrh.model.User;
import com.yrh.utils.AppException;

public interface UserDao {

	/**
	 * �ж��ƶ��û������û��Ƿ����
	 * @param name �û���
	 * @return true ��ʾ�Ѵ��� false ��ʾ������
	 * @throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	
	/**
	 * �����û�ע����Ϣ
	 * @param user �û�����
	 * @return true ��ʾ����ɹ� false ��ʾ����ʧ��
	 * @throws AppException
	 */
	public boolean add(User user) throws AppException;
}

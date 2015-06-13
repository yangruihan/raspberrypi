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
	
	/**
	 * ����¼�û����������Ƿ���ȷ
	 * @param user �û�����
	 * @return true ��ʾ��ȷ false ��ʾ����
	 * @throws AppException
	 */
	public boolean check(User user) throws AppException;
	
	/**
	 * ͨ���û�idȡ���û������Ϣ 
	 * @param userid �û�id
	 * @return 0 ��ͨ�༭ 1 ����Ա
	 * @throws AppException
	 */
	public int getRoleById(int userid) throws AppException;
	
	/**
	 * ͨ���û����õ��û������Ϣ
	 * @param name �û���
	 * @return 0 ��ͨ�༭ 1 ����Ա
	 * @throws AppException
	 */
	public int getRoleByName(String name) throws AppException;
	
	/**
	 * ͨ���û����õ��û�id
	 * @param name �û���
	 * @return �û�id
	 * @throws AppException
	 */
	public int getIdByName(String name) throws AppException;
}

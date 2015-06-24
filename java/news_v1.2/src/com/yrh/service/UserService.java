package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {

	private static UserDao userDao = new UserDaolmpl();

	/**
	 * �û�ע��
	 * 
	 * @param user
	 *            �û�ʵ��
	 * @return true ��ʾ�ɹ� false ��ʾʧ��
	 * @throws AppException
	 */
	public static boolean register(User user) throws AppException {
		boolean flag = false;
		if (!userDao.isExist(user.getName())) {
			if (userDao.add(user)) {
				System.out.println("��ӳɹ�");
				flag = true;
			} else {
				System.out.println("���ʧ��");
			}
		} else {
			System.out.println("�û����Ѵ���");
		}
		return flag;
	}
	
	/**
	 * ͨ���û��������¼
	 * @param name
	 * @param password
	 * @return true ��ʾ��¼�ɹ� false ��ʾ��¼ʧ��
	 * @throws AppException
	 */
	public static boolean login(String name, String password) throws AppException {
		boolean flag = false;
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		if (login(user)) {
			System.out.println("��¼�ɹ�");
			flag = true;
		} else {
			System.out.println("�û������������");
		}
		return flag;
	}

	/**
	 * �û���¼
	 * 
	 * @param user
	 *            �û�ʵ��
	 * @return true ��ʾ��¼�ɹ� false ��ʾ��¼ʧ��
	 * @throws AppException
	 */
	public static boolean login(User user) throws AppException {
		boolean flag = false;
		if (userDao.check(user)) {
			System.out.println("��½�ɹ�");
			flag = true;
		} else {
			System.out.println("�û������������");
		}
		return flag;
	}

	/**
	 * �����û�id�����û������Ϣ
	 * 
	 * @param userid
	 *            �û�id
	 * @return �û������Ϣ��0 ��ͨ�༭ 1 ����Ա��
	 * @throws AppException
	 */
	public static int getUserRole(int userid) throws AppException {
		int role;
		role = userDao.getRoleById(userid);
		System.out.println("�û����Ϊ��" + role);
		return role;
	}

	/**
	 * �����û��������û������Ϣ
	 * 
	 * @param name
	 *            �û���
	 * @return �û������Ϣ��0 ��ͨ�༭ 1 ����Ա��
	 * @throws AppException
	 */
	public static int getUserRole(String name) throws AppException {
		int role;
		role = userDao.getRoleByName(name);
		System.out.println("�û����Ϊ��" + role);
		return role;
	}

	/**
	 * ͨ���û�����ȡ�û�id
	 * 
	 * @param name
	 *            �û���
	 * @return �û�id
	 * @throws AppException
	 */
	public static int getUserID(String name) throws AppException {
		int id;
		id = userDao.getIdByName(name);
		System.out.println("�û�IDΪ��" + id);
		return id;
	}

}

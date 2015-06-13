package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {

	private static UserDao userDao = new UserDaolmpl();

	/**
	 * �û�ע��
	 * @param user �û�ʵ��
	 * @return true ��ʾ�ɹ� false ��ʾʧ��
	 * @throws AppException
	 */
	public static boolean register(User user) throws AppException {
		boolean flag = false;
		try {
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
		} catch (AppException e) {
			throw new AppException("com.yrh.service.UserService.register");
		}
		return flag;
	}
	
	/**
	 * �û���¼
	 * @param user �û�ʵ��
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
	
}

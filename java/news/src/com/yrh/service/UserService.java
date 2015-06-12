package com.yrh.service;

import com.yrh.dao.UserDao;
import com.yrh.dao.UserDaolmpl;
import com.yrh.model.User;
import com.yrh.utils.AppException;

public class UserService {
	
	private UserDao userDao = new UserDaolmpl();
	
	/**
	 * �û�ע��
	 * @param user
	 * @return true ��ʾ�ɹ� false ��ʾʧ��
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException {
		if (!userDao.isExist(user.getName())) {
			if (userDao.add(user)) {
				System.out.println("��ӳɹ�");
				return true;
			} else {
				System.out.println("���ʧ��");
			}
		} else {
			System.out.println("�û����Ѵ���");
		}
		return false;
	}
}

package com.yrh.service;

import java.util.ArrayList;
import com.yrh.dao.NewsDao;
import com.yrh.dao.NewsDaolmpl;
import com.yrh.model.News;
import com.yrh.utils.AppException;

public class NewsService {

	private static NewsDao newsDao = new NewsDaolmpl();

	/**
	 * ��������
	 * 
	 * @param news
	 *            ����ʵ��
	 * @return true ��ʾ�����ɹ� false ��ʾ����ʧ��
	 * @throws AppException
	 */
	public static boolean create(News news) throws AppException {
		boolean flag = false;
		if (newsDao.add(news)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * ��ô���״̬�������б�
	 * 
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getList(int state) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getList(state);
		return result;
	}

	/**
	 * �޸Ĵ���id�����ŵ�stateֵ
	 * 
	 * @param id
	 * @throws AppException
	 */
	public static boolean setState(int id, int state) throws AppException {
		boolean flag = false;
		if (newsDao.setState(id, state)) {
			flag = true;
		}
		return flag;
	}

}

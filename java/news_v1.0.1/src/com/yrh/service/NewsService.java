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
	 * ͨ�����ŵ����ͻ�������б�
	 * @param kind
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getNewsByKind(int newsTypeId) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getNewsByType(newsTypeId);
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
	
	/**
	 * ������¸��µ�����
	 * @param numbers ���Ÿ���
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getReNews(int numbers) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getReNews(numbers);
		return result;
	}
	
	/**
	 * ��õ����ǰ numbers ������
	 * @param numbers ���Ÿ���
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getHotNews(int numbers) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getHotNews(numbers);
		return result;
	}

	/**
	 * ͨ���û�id��ȡ��id����������
	 * @param ID
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getNewsByUserId(int ID) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getNewsByUserId(ID);
		return result;
	}
	
	/**
	 * ͨ������id��ȡ����
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public static News getNewsById(int id) throws AppException {
		return newsDao.getNewsById(id);
	}
	
	/**
	 * ����������Ϣ
	 * @param news
	 * @return
	 * @throws AppException
	 */
	public static boolean update(News news) throws AppException {
		boolean flag = false;
		if (newsDao.update(news)) {
			flag = true;
		}
		return flag;
	}
}

package com.yrh.service;

import java.util.ArrayList;
import com.yrh.dao.NewsDao;
import com.yrh.dao.NewsDaolmpl;
import com.yrh.model.News;
import com.yrh.utils.AppException;

public class NewsService {

	private static NewsDao newsDao = new NewsDaolmpl();

	/**
	 * 创建新闻
	 * 
	 * @param news
	 *            新闻实例
	 * @return true 表示创建成功 false 表示创建失败
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
	 * 获得传入状态的新闻列表
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
	 * 通过新闻的类型获得新闻列表
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
	 * 修改传入id的新闻的state值
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
	 * 获得最新更新的新闻
	 * @param numbers 新闻个数
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getReNews(int numbers) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getReNews(numbers);
		return result;
	}
	
	/**
	 * 获得点击量前 numbers 的新闻
	 * @param numbers 新闻个数
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getHotNews(int numbers) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getHotNews(numbers);
		return result;
	}

	/**
	 * 通过用户id获取该id创建的新闻
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
	 * 通过新闻id获取新闻
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public static News getNewsById(int id) throws AppException {
		return newsDao.getNewsById(id);
	}
	
	/**
	 * 更新新闻信息
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

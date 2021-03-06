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
	 * 获得已发布的新闻列表
	 * 
	 * @return
	 * @throws AppException
	 */
	public static ArrayList<News> getList(int state) throws AppException {
		ArrayList<News> result = new ArrayList<News>();
		result = newsDao.getList(state);
		return result;
	}

}

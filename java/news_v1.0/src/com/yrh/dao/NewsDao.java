package com.yrh.dao;

import java.util.ArrayList;
import com.yrh.model.News;
import com.yrh.utils.AppException;

public interface NewsDao {
	
	/**
	 * 创建新闻 
	 * @param news 新闻实例
	 * @return true 创建成功 false 创建失败
	 * @throws AppException
	 */
	public boolean add(News news) throws AppException;
	
	/**
	 * 根据新闻状态获得新闻列表
	 * @param state 新闻状态
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getList(int state) throws AppException;
}

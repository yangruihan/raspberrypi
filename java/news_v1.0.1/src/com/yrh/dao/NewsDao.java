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
	
	/**
	 * 根据新闻的类型获得新闻列表
	 * @param kind
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getNewsByType(int newsTypeId) throws AppException;
	
	/**
	 * 根据输入id，将其state修改为输入值
	 * @param id
	 * @param state
	 * @return
	 * @throws AppException
	 */
	public boolean setState(int id, int state) throws AppException;
	
	/**
	 * 获得最新更新的新闻
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getReNews(int numbers) throws AppException;
	
	/**
	 * 获得最热的新闻
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getHotNews(int numbers) throws AppException;
	
	/**
	 * 获得该id创建的新闻
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getNewsByUserId(int id) throws AppException;
	
	/**
	 * 通过新闻的id获取新闻
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public News getNewsById(int id) throws AppException;
	
	/**
	 * 更新新闻信息
	 * @param news
	 * @return
	 * @throws AppException
	 */
	public boolean update(News news) throws AppException;
}

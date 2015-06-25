package com.yrh.dao;

import java.util.ArrayList;
import com.yrh.model.News;
import com.yrh.utils.AppException;

public interface NewsDao {
	
	/**
	 * �������� 
	 * @param news ����ʵ��
	 * @return true �����ɹ� false ����ʧ��
	 * @throws AppException
	 */
	public boolean add(News news) throws AppException;
	
	/**
	 * ��������״̬��������б�
	 * @param state ����״̬
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getList(int state) throws AppException;
	
	/**
	 * �������ŵ����ͻ�������б�
	 * @param kind
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getNewsByType(int newsTypeId) throws AppException;
	
	/**
	 * ��������id������state�޸�Ϊ����ֵ
	 * @param id
	 * @param state
	 * @return
	 * @throws AppException
	 */
	public boolean setState(int id, int state) throws AppException;
	
	/**
	 * ������¸��µ�����
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getReNews(int numbers) throws AppException;
	
	/**
	 * ������ȵ�����
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getHotNews(int numbers) throws AppException;
	
	/**
	 * ��ø�id����������
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public ArrayList<News> getNewsByUserId(int id) throws AppException;
	
	/**
	 * ͨ�����ŵ�id��ȡ����
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public News getNewsById(int id) throws AppException;
	
	/**
	 * ����������Ϣ
	 * @param news
	 * @return
	 * @throws AppException
	 */
	public boolean update(News news) throws AppException;
}

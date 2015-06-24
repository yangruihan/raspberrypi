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
}

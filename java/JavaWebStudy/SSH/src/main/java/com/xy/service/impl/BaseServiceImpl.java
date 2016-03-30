package com.xy.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xy.dao.BaseDaoInter;
import com.xy.service.BaseServiceInter;
import com.xy.util.QueryResult;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class BaseServiceImpl<T extends Serializable> implements BaseServiceInter<T> {

	@Autowired
	private BaseDaoInter<T> baseDao;		//从容器中注入session工厂【无需get,set方法】
	
	@Override
	public Integer save(T t) {
		return baseDao.save(t);
	}

	@Override
	public void saveAll(Collection<T> ct) {
		baseDao.saveAll(ct);
	}

	@Override
	public T findById(Integer id) {
		return baseDao.findById(id);
	}

	@Override
	public T update(T t) {
		return baseDao.update(t);
	}

	@Override
	public T saveOrUpdate(T t) {
		return baseDao.saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	@Override
	public void deleteAll(Collection<T> ct) {
		baseDao.deleteAll(ct);
	}

	@Override
	public boolean deleteById(Integer id) {
		return baseDao.deleteById(id);
	}

	@Override
	public QueryResult<T> loadAll() {
		return baseDao.loadAll();
	}

	@Override
	public QueryResult<T> load(int page, int rows) {
		return baseDao.load(page, rows);
	}

	@Override
	public long getTotalCount() {
		return baseDao.getTotalCount();
	}
	/******************************HQL******************************/

	@Override
	public QueryResult<T> getScrollData() {
		return baseDao.getScrollData();
	}

	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult) {
		return baseDao.getScrollData(firstResult, maxResult);
	}

	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, String> orderby) {
		return baseDao.getScrollData(firstResult, maxResult, orderby);
	}

	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params) {
		return baseDao.getScrollData(firstResult, maxResult, where, params);
	}

	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params, LinkedHashMap<String, String> orderby) {
		return baseDao.getScrollData(firstResult, maxResult, where, params, orderby);
	}
	
}

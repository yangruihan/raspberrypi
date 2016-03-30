package com.xy.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.xy.dao.BaseDaoInter;
import com.xy.util.QueryResult;
/**
 * 不一定必须是abstract类型的，
 * 请不要对BaseDaoImpl使用@Repository注解，因为无法直接指定clazz属性值
 * class值由继承类来指定
 * @author BearSmall
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T extends Serializable> implements BaseDaoInter<T>{
	@Autowired
	private SessionFactory sessionFactory;		//从容器中注入session工厂【无需get,set方法】
	
	private Class<T> clazz;						//【实体类对应的Class对象】
	
	/**
	 * //向子类暴露的接口获用来获取sessionFactory
	 * @return sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * 保留指定clazz值的接口【通过子类显示调用父类的构造函数来指定】
	 * @param clazz
	 */
	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

//	@SuppressWarnings("unchecked")
//	public BaseDaoImpl() {//另外一种方式指定clazz值，要求类必须是abstract类型
//		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
//		clazz= (Class<T>)(parameterizedType.getActualTypeArguments()[0]); 
//	}
	
	@Override
	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	@Override
	public Integer save(T t) {
		Session session = getSession();
		return (Integer) session.save(t);
	}
	@Override
	public T findById(Integer id) {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(clazz, id);
		return t;
	}
	@Override
	public void saveAll(Collection<T> ct) {
		Session session = getSession();
		for (T t : ct) {
			session.save(t);
		}
	}
	@Override
	public T update(T t) {
		Session session = getSession();
		session.update(t);
		return t;
	}
	@Override
	public void deleteAll(Collection<T> ct) {
		Session session= getSession();
		for (T t : ct) {
			session.delete(t);
		}
	}
	@Override
	public T saveOrUpdate(T t) {
		Session session = getSession();
		session.saveOrUpdate(t);
		return t;
	}
	@Override
	public void delete(T t) {
		Session session = getSession();
		session.delete(t);
	}
	@Override
	public boolean deleteById(Integer id) {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(clazz, id);
		if(t==null)
			return false;
		session.delete(t);
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<T> loadAll() {
		Session session= getSession();
		Criteria criteria = session.createCriteria(clazz);
		QueryResult<T> result = new QueryResult<>();
		result.setDatas(criteria.list());
		result.setTotalCount(Long.parseLong(criteria.setProjection(Projections.rowCount()).uniqueResult().toString()));
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<T> load(int page, int rows) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);
		QueryResult<T> result = new QueryResult<>();
		result.setDatas(criteria.list());
		result.setTotalCount(Long.parseLong(criteria.setProjection(Projections.rowCount()).uniqueResult().toString()));
		return result;
	}
	@Override
	public long getTotalCount() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		Object object = criteria.setProjection(Projections.rowCount()).uniqueResult();
		long totalCount = 0;
		if(object!=null){			
			totalCount = Long.parseLong(object.toString()); 
		}
		return totalCount;
	}	
	/******************************HQL******************************/
	@Override
	public QueryResult<T> getScrollData(){
		return getScrollData(-1, -1, null, null, null);
	}
	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult){
		return getScrollData(firstResult, maxResult, null, null, null);
	}
	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, String> orderby){
		return getScrollData(firstResult, maxResult, null, null, orderby);
	}
	@Override
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object[] params){
		return getScrollData(firstResult, maxResult, where, params, null);
	}
	@Override
	@SuppressWarnings("unchecked")
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object[] params, LinkedHashMap<String, String> orderby){
		String entityName = clazz.getSimpleName();
		String whereql = where!=null && !"".equals(where.trim()) ? " where "+ where : "" ;
		Session session=getSession();
		Query query =session.createQuery("select o from "+ entityName +" o" + whereql + buildOrderby(orderby));
		if(firstResult!=-1 && maxResult!=-1) 
			query.setFirstResult(firstResult).setMaxResults(maxResult);
		setQueryParameter(query, params);
		
		QueryResult<T> qr = new QueryResult<T>();
		//qr.setResultlist(query.getResultList());
		Query queryCount =session.createQuery("select count(o) from "+ entityName +" o"+ whereql);
		setQueryParameter(queryCount, params);
		long count=(Long)queryCount.uniqueResult();
		qr.setTotalCount(count);
		qr.setDatas(query.list());
		return qr;
	}
	/**
	 * 设置查询参数
	 * @param query 查询对象
	 * @param params 参数值
	 */
	public static void setQueryParameter(Query query, Object[] params){
		if(params!=null){
			for(int i = 0; i < params.length ; i++){
				query.setParameter(i, params[i]);
			}
		}
	}
	/**
	 * 构建排序语句
	 * @param orderby 排序属性与asc/desc, Key为属性,Value为asc/desc
	 * @return
	 */
	public static String buildOrderby(LinkedHashMap<String, String> orderby){
		StringBuilder sb = new StringBuilder();
		if(orderby!=null && !orderby.isEmpty()){
			sb.append(" order by ");
			for(Map.Entry<String, String> entry : orderby.entrySet()){
				sb.append("o.").append(entry.getKey()).append(" ").append(entry.getValue()).append(',');
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}

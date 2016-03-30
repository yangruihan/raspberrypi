package com.xy.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.hibernate.Session;

import com.xy.util.QueryResult;

public interface BaseDaoInter<T extends Serializable> {
	/**
	 * 由session工厂获取当前session对象
	 * @return
	 */
	public Session getSession();
	/**
	 * 将实体对象保存到数据库中
	 * @param t 待保存的实体对象
	 * @return 实体对象的ID
	 */
	public Integer save(T t);
	/**
	 * 将实体对象【集合】保存到数据库中
	 * @param ct 实体对象【集合】
	 */
	public void saveAll(Collection<T> ct);
	/**
	 * 根据Id查询实体对象
	 * @param id 表记录中的对应的id字段
	 * @return 对应的实体对象
	 */
	public T findById(Integer id);
	/**
	 * 更新一条记录
	 * @param t 待更新记录对应的实体对象
	 * @return 更新后的实体对象
	 */
	public T update(T t);
	/**
	 * 保存或更新一个实体对象到表记录中
	 * @param t 待更新的实体对象
	 * @return 更新后的实体对象
	 */
	public T saveOrUpdate(T t);
	/**
	 * 删除一个实体对象对应的表记录
	 * @param t 待删除的实体对象
	 */
	public void delete(T t);
	/**
	 * 删除一组记录
	 * @param ct 待删除记录集合
	 */
	public void deleteAll(Collection<T> ct);
	/**
	 * 根据id删除一条记录
	 * @param id 待删除记录id
	 * @return 是否删除成功（id是否有效）
	 */
	public boolean deleteById(Integer id);
	/**
	 * 加载所有记录集合
	 * @return 所有记录集合
	 */
	public QueryResult<T> loadAll();
	/**
	 * 分页加载记录集合
	 * @param page 当前第多少页
	 * @param rows 每页最多多少行数据
	 * @return 第page页的数据集合
	 */
	public QueryResult<T> load(int page,int rows);
	/**
	 * 获取总记录数
	 * @return 总数
	 */
	public long getTotalCount();
	
	/******************************HQL******************************/
	/**
	 * 分页获取所有记录
	 * @return
	 */
	public QueryResult<T> getScrollData();
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param orderby 排序,Key为排序属性,Value为asc/desc,如:
	 *  LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("email", "asc");
		orderby.put("password", "desc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, String> orderby);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param where 条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and o.password=?2
	 * @param params 条件语句出现的位置参数值
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object[] params);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param where 条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and o.password=?2
	 * @param params 条件语句出现的位置参数值
	 * @param orderby 排序,Key为排序属性,Value为asc/desc,如:
	 *  LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("email", "asc");
		orderby.put("password", "desc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object[] params, LinkedHashMap<String, String> orderby);

}

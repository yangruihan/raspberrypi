package com.yrh.java.jdbc;

import java.util.List;
import java.util.Map;

/**
 * control 层
 * @author Yrh
 *
 */
public class GoddessAction {
	
	private GoddessDao goddessDao = new GoddessDao();
	
	/**
	 * 增加
	 * @param g
	 * @throws Exception 
	 */
	public void add(Goddess g) throws Exception {
		goddessDao.addGoddess(g);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception 
	 */
	public void del(Integer id) throws Exception {
		goddessDao.delGoddess(id);
	}
	
	/**
	 * 更新
	 * @param g
	 * @throws Exception 
	 */
	public void update(Goddess g) throws Exception {
		goddessDao.updateGoddess(g);
	}
	
	/**
	 * 查询全部
	 * @return
	 * @throws Exception 
	 */
	public List<Goddess> query() throws Exception {
		return goddessDao.queryGoddesses();
	}
	
	/**
	 * 按条件查询
	 * @return
	 * @throws Exception 
	 */
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception {
		return goddessDao.queryGoddesses(params);
	}
	
	/**
	 * 获取某个 id 的详细信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Goddess get(Integer id) throws Exception {
		return goddessDao.queryGoddess(id);
	}
}

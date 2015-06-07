package com.yrh.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据库访问对象类 DAO(database access object)
 * 
 * model 层
 * 
 * @author Yrh
 *
 */
public class GoddessDao {

	/**
	 * 添加
	 * @param g 添加的数据
	 */
	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into imooc_goddess(user_name,sex,age,birthday,"
				+ "email,mobile,create_user,create_date,update_user,update_date,"
				+ "isdel) values(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		// 预编译指令
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 传递参数
		psmt.setString(1, g.getName());
		psmt.setInt(2, g.getSex());
		psmt.setInt(3, g.getAge());
		psmt.setDate(4, new Date(g.getBirthday().getTime()));
		psmt.setString(5, g.getEmail());
		psmt.setString(6, g.getMobile());
		psmt.setString(7, g.getCreate_user());
		psmt.setString(8, g.getUpdate_user());
		psmt.setInt(9, g.getIsdel());

		// 执行
		psmt.execute();
	}

	/**
	 * 删除
	 * @param id 删除的 id
	 */
	public void delGoddess(Integer id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from imooc_goddess" + " where id=?";
		// 预编译指令
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 传递参数
		psmt.setInt(1, id);

		// 执行
		psmt.execute();
	}

	/**
	 * 更新
	 * @param g 更新的数据
	 */
	public void updateGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "update imooc_goddess set user_name=?,sex=?,age=?,birthday=?,"
				+ "email=?,mobile=?,update_user=?,update_date=current_date(),isdel=0"
				+ " where id=?";
		// 预编译指令
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 传递参数
		psmt.setString(1, g.getName());
		psmt.setInt(2, g.getSex());
		psmt.setInt(3, g.getAge());
		psmt.setDate(4, new Date(g.getBirthday().getTime()));
		psmt.setString(5, g.getEmail());
		psmt.setString(6, g.getMobile());
		psmt.setString(7, g.getUpdate_user());
		psmt.setInt(8, g.getId());

		// 执行
		psmt.execute();
	}

	/**
	 * 查询
	 * @return 结果列表
	 */
	public List<Goddess> queryGoddesses() throws Exception {
		List<Goddess> list = new ArrayList<Goddess>();

		// 获得连接
		Connection conn = DBUtil.getConnection();
		// 获得 Statement 实例
		Statement stmt = conn.createStatement();
		// 通过 Statement 的 executeQuery() 方法进行数据库查询
		ResultSet result = stmt
				.executeQuery("Select * from imooc_goddess;");

		Goddess g = null;

		while (result.next()) {
			g = new Goddess();
			g.setId(result.getInt("id"));
			g.setName(result.getString("user_name"));
			g.setSex(result.getInt("sex"));
			g.setAge(result.getInt("age"));
			g.setBirthday(result.getDate("birthday"));
			g.setEmail(result.getString("email"));
			g.setMobile(result.getString("mobile"));
			g.setCreate_user(result.getString("create_user"));
			g.setCreate_date(result.getDate("create_date"));
			g.setUpdate_user(result.getString("update_user"));
			g.setUpdate_date(result.getDate("update_date"));
			g.setIsdel(result.getInt("isdel"));
			
			list.add(g);
		}

		return list;
	}
	
	/**
	 * 不固定参数查询
	 * @param params 参数
	 * @return 结果列表
	 */
	public List<Goddess> queryGoddesses(List<Map<String, Object>> params) throws Exception {
		List<Goddess> list = new ArrayList<Goddess>();

		// 获得连接
		Connection conn = DBUtil.getConnection();
		
		StringBuilder sql = new StringBuilder("Select * from imooc_goddess where 1=1 ");
		
		if (params != null && params.size() > 0) {
			 for (int i = 0; i < params.size(); i++) {
				 Map<String, Object> param = params.get(i);
				 sql.append(" " + param.get("link"));
				 sql.append(" " + param.get("name"));
				 sql.append(" " + param.get("rela"));
				 sql.append(" " + param.get("value"));
			 }
		}
		
		PreparedStatement psmt = conn.prepareStatement(sql.toString());
		
		ResultSet result = psmt.executeQuery();

		Goddess g = null;

		while (result.next()) {
			g = new Goddess();
			g.setId(result.getInt("id"));
			g.setName(result.getString("user_name"));
			g.setSex(result.getInt("sex"));
			g.setAge(result.getInt("age"));
			g.setBirthday(result.getDate("birthday"));
			g.setEmail(result.getString("email"));
			g.setMobile(result.getString("mobile"));
			g.setCreate_user(result.getString("create_user"));
			g.setCreate_date(result.getDate("create_date"));
			g.setUpdate_user(result.getString("update_user"));
			g.setUpdate_date(result.getDate("update_date"));
			g.setIsdel(result.getInt("isdel"));
			
			list.add(g);
		}

		return list;
	}

	/*
	 * 查询单个详细信息
	 */
	public Goddess queryGoddess(Integer id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from imooc_goddess" + " where id=?";
		// 预编译指令
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 传递参数
		psmt.setInt(1, id);

		// 执行
		ResultSet result = psmt.executeQuery();

		Goddess g = null;
		while (result.next()) {
			g = new Goddess();
			g.setId(result.getInt("id"));
			g.setName(result.getString("user_name"));
			g.setSex(result.getInt("sex"));
			g.setAge(result.getInt("age"));
			g.setBirthday(result.getDate("birthday"));
			g.setEmail(result.getString("email"));
			g.setMobile(result.getString("mobile"));
			g.setCreate_user(result.getString("create_user"));
			g.setCreate_date(result.getDate("create_date"));
			g.setUpdate_user(result.getString("update_user"));
			g.setUpdate_date(result.getDate("update_date"));
			g.setIsdel(result.getInt("isdel"));
		}
		
		return g;
	}
}

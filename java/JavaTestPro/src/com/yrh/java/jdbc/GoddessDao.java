package com.yrh.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库访问对象类 DAO(database access object)
 * 
 * @author Yrh
 *
 */
public class GoddessDao {

	/*
	 * 添加
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

	/*
	 * 删除
	 */
	public void delGoddess() {

	}

	/*
	 * 更新
	 */
	public void updateGoddess() {

	}

	/*
	 * 查询
	 */
	public List<Goddess> queryGoddess() throws Exception {
		List<Goddess> list = new ArrayList<Goddess>();

		// 获得连接
		Connection conn = DBUtil.getConnection();
		// 获得 Statement 实例
		Statement stmt = conn.createStatement();
		// 通过 Statement 的 executeQuery() 方法进行数据库查询
		ResultSet resultSet = stmt
				.executeQuery("Select user_name,age from imooc_goddess;");

		Goddess goddess = null;

		while (resultSet.next()) {
			goddess = new Goddess();
			goddess.setName(resultSet.getString("user_name"));
			goddess.setAge(resultSet.getInt("age"));
			list.add(goddess);
		}

		return list;
	}
}

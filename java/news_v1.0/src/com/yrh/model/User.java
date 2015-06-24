package com.yrh.model;

/**
 * 用户类
 * @author Yrh
 *
 */
public class User {

	private int id;			// 用户id
	private String name;	// 用户姓名
	private String password;// 用户密码
	private int role;		// 用户身份（0：普通编辑；1：管理员）
	private int del;		// 是否删除（0：未删除；1：已删除）
	
	public User() {
		id = 0;
		name = "";
		password = "";
		role = 0;
		del = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
}

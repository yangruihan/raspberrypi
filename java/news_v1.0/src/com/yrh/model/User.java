package com.yrh.model;

/**
 * �û���
 * @author Yrh
 *
 */
public class User {

	private int id;			// �û�id
	private String name;	// �û�����
	private String password;// �û�����
	private int role;		// �û���ݣ�0����ͨ�༭��1������Ա��
	private int del;		// �Ƿ�ɾ����0��δɾ����1����ɾ����
	
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

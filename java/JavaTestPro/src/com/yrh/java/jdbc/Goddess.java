package com.yrh.java.jdbc;

import java.util.Date;

/**
 * 女神类
 * 
 * @author Yrh
 *
 */
public class Goddess {

	private Integer id;
	private String user_name;
	private Integer sex;
	private Integer age;
	private Date birthday;
	private String email;
	private String mobile;
	private String create_user;
	private Date create_date;
	private String update_user;
	private Date update_date;
	private Integer isdel;
	
	/*
	 * 覆写 toString 方法
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "\n------------------"
				+ "ID:" + id 
				+ "\n用户名:" + user_name
				+ "\n性别:" + sex
				+ "\n年龄:" + age
				+ "\n生日:" + birthday.toString()
				+ "\n邮箱:" + email
				+ "\n手机号:" + mobile
				+ "\n创建人:" + create_user
				+ "\n创建时间:" + create_date.toString()
				+ "\n更新人:" + update_user
				+ "\n更新时间:" + update_date.toString(); 
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String user_name) {
		this.user_name = user_name;
	}

	public Integer getSex() {
		return sex;
	}

	public Integer getAge() {
		return age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getIsdel() {
		return isdel;
	}

}

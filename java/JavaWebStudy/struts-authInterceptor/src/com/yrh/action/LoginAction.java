package com.yrh.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String username;
	private String password;
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		
		if ("admin".equals(username) && "admin".equals(password)) {
			session.put("LOGIN_INFO", username);
			return SUCCESS;
		} else {
			session.put("ERROR_INFO", "用户名或密码错误");
			return ERROR;
		}
		
	}
	
}

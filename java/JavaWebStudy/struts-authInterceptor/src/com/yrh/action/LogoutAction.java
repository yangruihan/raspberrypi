package com.yrh.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	
	public String logout(){ 
		if (session.containsKey("LOGIN_INFO")) {
			session.remove("LOGIN_INFO");
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}

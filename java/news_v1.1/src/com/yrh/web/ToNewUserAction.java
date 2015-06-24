package com.yrh.web;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ToNewUserAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "newUser";
	}
}

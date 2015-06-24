package com.yrh.web;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ToAdminAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "adminFrame";
	}
}

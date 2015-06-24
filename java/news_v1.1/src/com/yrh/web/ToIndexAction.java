package com.yrh.web;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ToIndexAction extends ActionSupport {

	/**
	 * 处理初始页面的跳转
	 */
	@Override
	public String execute() throws Exception {
		return "index";
	}
}

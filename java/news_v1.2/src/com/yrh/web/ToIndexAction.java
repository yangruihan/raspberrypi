package com.yrh.web;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ToIndexAction extends ActionSupport {

	/**
	 * �����ʼҳ�����ת
	 */
	@Override
	public String execute() throws Exception {
		return "index";
	}
}

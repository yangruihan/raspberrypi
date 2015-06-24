package com.yrh.web;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ToEditorAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "editorFrame";
	}
}

package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户请求，输出结果页面
 * @author Yrh
 *
 */
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); 	// 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8");	// 设置输出内容的编码
		PrintWriter out = resp.getWriter();	// 获得一个输出对象
		// ...输出头部声明
		// ...输出标准的 HTML 结构
		// 页面主体信息
		out.println("欢迎进入新闻系统！");
		// 关闭输出流
		out.flush();
		out.close();
	}
}

package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ToRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); 	// 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8");	// 设置输出内容的编码
		PrintWriter out = resp.getWriter();
		
		out.print("<form action=\"register\" name=\"toregister\" method=\"post\">");
		out.print("<table>");
		
		out.print("<tr>");
		out.print("<td>用户名：</td>");
		out.print("<td><input type=\"text\" name=\"name\"/></td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>密码：</td>");
		out.print("<td><input type=\"password\" name=\"password\"/></td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>重复密码：</td>");
		out.print("<td><input type=\"password\" name=\"password2\"/></td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td colspan=\"2\">");
		out.print("<input type=\"submit\" name=\"click\" value=\"提交\">");
		out.print("</tr>");
		
		out.print("</table>");
		out.print("</form>");
		
		String result = (String) req.getAttribute("result");
		if (result != null) {
			out.print("<span color=\"red\">"+result+"</span>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}

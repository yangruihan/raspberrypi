<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	response.setContentType("text/html;charset=utf-8"); // 设置网页的MIME类型
	
	out.print("<h1>这是一个response测试页面</h1>");
	out.print("<hr>");
	
	PrintWriter outer = response.getWriter();
	outer.print("你好");
	
	// response.sendRedirect("login.jsp"); // 重定向
	// response.sendRedirect("request.jsp");
	
	request.getRequestDispatcher("request.jsp").forward(request, response);
%>

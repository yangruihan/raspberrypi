<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String username = "";
	String password = "";
	
	username = request.getParameter("username");
	password = request.getParameter("password");
	
	if (username.equals("admin") && password.equals("admin")) {
		response.sendRedirect("login_suc.jsp");
	} else {
		response.sendRedirect("login_fai.jsp");
	}
%>


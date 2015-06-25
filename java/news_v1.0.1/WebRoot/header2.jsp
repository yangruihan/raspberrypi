<%@ page language="java" import="java.util.*"  import="com.yrh.model.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 页头</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
	<% 
	User user = (User)session.getAttribute("user");
	String name = "";
	if (user != null) {
		name = user.getName();
	}
%>
		<!-- header start -->
		<div class="header">
			<div class="toplinks">
				您好：<%= name %>，欢迎使用新闻系统！<span>【<a href="index" target="_top">返回首页</a>】【<a href="login.jsp" target="_top">注销登录</a>】</span>
			</div>
			<h1>
				<a href="index.htm" target="_top"><img src="images/logo.png" height="56" width="260" alt="新闻系统" /></a>
			</h1>
		</div>
		<!-- header end -->
	</body>
</html>

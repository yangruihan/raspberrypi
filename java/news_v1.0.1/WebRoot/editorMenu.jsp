﻿<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 菜单栏</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="menu">
			<ul class="c1 ico3">
                <li><a href="toCreateNews" target="main">创建新闻</a></li>
               <li><a href="toMyNews" target="main">我的新闻</a></li>
			</ul>
		</div>
	</body>
</html>
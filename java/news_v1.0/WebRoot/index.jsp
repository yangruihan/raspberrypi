<%@ page language="java" import="java.util.*" import="com.yrh.model.*"
	import="com.yrh.service.*" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新闻系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<h1>新闻系统</h1> <a href="toLogin" >登录</a> <a href="toRegister">注册</a>
	<hr>
		ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内容<br>
	
	<%
		ArrayList<News> newsList = (ArrayList<News>) request
				.getAttribute("newsList");
		if (newsList == null) {
			out.print("暂无新闻<br>");
		} else {
			for (News news : newsList) {
				out.print((newsList.indexOf(news) + 1)
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + news.getTitle()
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ NewsTypeService.getNewsTypeName(news.getNewsTypeId())
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ news.getContent()
						+ "<hr>");
			}
		}
	%>
</body>
</html>

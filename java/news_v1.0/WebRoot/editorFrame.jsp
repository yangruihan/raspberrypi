<%@ page language="java" import="java.util.*"  import="com.yrh.model.*" contentType="text/html; charset=UTF-8"%>
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
<% 
	User user = (User)session.getAttribute("user");
	String name = "";
	if (user != null) {
		name = user.getName();
	}
%>
欢迎您，编辑<%= name %><br>
<a href="toCreateNews">创建新闻</a><br>
<a href="logout" >注销</a><br>

<frameset rows="100,*,70">
	<frame name="header" />
	<!-- header -->

	<frameset cols="200,*">
		<frame name="left" /> <!-- left -->
		<frame name="main" /> <!-- main -->
	</frameset>

	<frame name="footer" /> <!-- footer -->
</frameset>

</body>

</html>

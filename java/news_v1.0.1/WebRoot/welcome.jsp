<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 欢迎</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="content">
			<p>
				欢迎进入新闻系统！
				<br />
				现在时间：15:08:13
			</p>
		</div>
	</body>
</html>

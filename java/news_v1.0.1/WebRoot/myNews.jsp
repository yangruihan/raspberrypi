<%@page import="javafx.scene.layout.Border"%>
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

<title>My JSP 'myNews.jsp' starting page</title>

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
	<h1>新闻系统</h1>
	<hr>
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
			out.print("<font color=\"#FF0000\">" + message + "</font><br>");
		}
	%>
	<form action="toUpdateNews" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>标题</th>
				<th>类型</th>
				<th>状态</th>
			</tr>
			<%!String getState(int i) {
		if (i == 0) {
			return "未审核";
		} else if (i == 1) {
			return "已发布";
		} else {
			return "已废除";
		}
	}%>
			<%
				ArrayList<News> newsList = (ArrayList<News>) request
						.getAttribute("myNews");
				if (newsList == null) {
					out.print("暂无新闻<br>");
				} else {
					for (News news : newsList) {
						out.print("<tr><td>"
								+ news.getId()
								+ "</td> <td><a href=\"toNewsDetail?newsid=" + news.getId() +"\" target=\"_blank\">"
								+ news.getTitle()
								+ "</a></td><td>"
								+ NewsTypeService.getNewsTypeName(news
										.getNewsTypeId()) + "</td><td>"
								+ getState(news.getState()) + "</td></tr>");
					}
				}
			%>
		</table>
		请输入要修改的新闻ID号：<input type="text" name="newsUpdateId"> <input
			type="submit" name="check" value="确定"><br> 请输入要删除的新闻ID号：<input
			type="text" name="newsDeleteId"> <input type="submit"
			name="delete" value="确定"><br>
	</form>
</body>
</html>

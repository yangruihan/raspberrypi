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

<title>My JSP 'managerNews.jsp' starting page</title>

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
	<form action="managerNews" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>标题</th>
				<th>类型</th>
			</tr>
			<%
				ArrayList<News> newsList = (ArrayList<News>) request
						.getAttribute("newsList");
				if (newsList == null) {
					out.print("暂无新闻<br>");
				} else {
					for (News news : newsList) {
						out.print("<tr><td>"
								+ news.getId()
								+ "</td> <td><a href=\"toNewsDetail?newsid=" + news.getId() +"\"  target=\"_blank\">"
								+ news.getTitle()
								+ "</a></td><td>"
								+ NewsTypeService.getNewsTypeName(news
										.getNewsTypeId()) + "</td></tr>");
					}
				}
			%>
		</table>
			请输入审核通过的新闻编号(以空格区别)：
			<input type="text" name="passid">
			<br>
			<input type="submit" name="check" value="确定">
			<br>
	</form>
</body>
</html>

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ page import="com.yrh.service.*" import="com.yrh.model.*"%>
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

<title>My JSP 'updateNews.jsp' starting page</title>

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
			out.print("<font color=\"#FF0000\">" + message + "</font>");
		}

		int newsid = 0;
		News news = new News();

		try {
			newsid = Integer.parseInt(request.getParameter("newsUpdateId"));
			news = NewsService.getNewsById(newsid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("toError");
		}
	%>

	<form action="updateNews" method="post">
		<table>
			<tr>
				<td>新闻ID：</td>
				<td><input type="text" name="newsId" 
					value="<%=news.getId()%>" size="30" readonly="readonly"></td>
			</tr>
			<tr>
				<td>新闻标题*：</td>
				<td><input type="text" name="newsTitle" size="30"
					value="<%=news.getTitle()%>"></td>
			</tr>
			<tr>
				<td>新闻类型：</td>
				<td><select name="newsKind">
						<%
							int kind = news.getNewsTypeId();
							if (kind == 1) {
								out.print("<option style=\"width:200px\" selected=\"selected\">国际新闻</option>");
							} else {
								out.print("<option style=\"width:200px\">国际新闻</option>");
							}
							if (kind == 2) {
								out.print("<option style=\"width:200px\" selected=\"selected\">国内新闻</option>");
							} else {
								out.print("<option style=\"width:200px\">国内新闻</option>");
							}
							if (kind == 3) {
								out.print("<option style=\"width:200px\" selected=\"selected\">娱乐新闻</option>");
							} else {
								out.print("<option style=\"width:200px\">娱乐新闻</option>");
							}
							if (kind == 4) {
								out.print("<option style=\"width:200px\" selected=\"selected\">体育新闻</option>");
							} else {
								out.print("<option style=\"width:200px\">体育新闻</option>");
							}
							if (kind == 5) {
								out.print("<option style=\"width:200px\" selected=\"selected\">财经频道</option>");
							} else {
								out.print("<option style=\"width:200px\">财经频道</option>");
							}
							if (kind == 6) {
								out.print("<option style=\"width:200px\" selected=\"selected\">汽车频道</option>");
							} else {
								out.print("<option style=\"width:200px\">汽车频道</option>");
							}
							if (kind == 7) {
								out.print("<option style=\"width:200px\" selected=\"selected\">电子频道</option>");
							} else {
								out.print("<option style=\"width:200px\">电子频道</option>");
							}
						%>
				</select>
				</td>
			</tr>
			<tr>
				<td>新闻来源：</td>
				<td><input type="text" name="newsSource" size="30"
					value="<%=news.getSource()%>"></td>
			</tr>
			<tr>
				<td>新闻作者：</td>
				<td><input type="text" name="newsAuthor" size="30"
					value="<%=news.getAuthor()%>"></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input type="text" name="newsCreateTime" 
					value="<%=news.getCreateTime()%>" size="30" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" name="newsKeyword" size="30"
					value="<%=news.getKeywords()%>">
				</td>
			</tr>
			<tr>
			</tr>
		</table>
		<font color="red">（其中*项为必填项）</font><br> 内容*：<br>
		<textarea name="newsContent" rows="15" cols="80""><%=news.getContent()%></textarea>
		<br> <input type="submit" name="check" value="确认更改">
	</form>
	<input type="submit" name="cancel" value="取消更改"
		onClick="window.location.href='toMyNews'">
</body>
</html>

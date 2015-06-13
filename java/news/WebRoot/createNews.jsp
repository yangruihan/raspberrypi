<%@page import="java.text.SimpleDateFormat"%>
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
		String message = (String) request.getAttribute("message");
		if (message != null) {
			out.print("<font color=\"#FF0000\">" + message + "</font>");
		}
	%>

	<form action="createNews" method="post">
		<%
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy年MM月dd日 HH时mm分ss秒");
			String time = format.format(new Date()).toString();
		%>
		<table>
			<tr>
				<td>新闻标题*：</td>
				<td><input type="text" name="newsTitle" size="30"></td>
			</tr>
			<tr>
				<td>新闻类型：</td>
				<td><select name="newsKind">
						<option style="width:200px">国际新闻</option>
						<option style="width:200px">国内新闻</option>
						<option style="width:200px">娱乐新闻</option>
						<option style="width:200px">体育新闻</option>
						<option style="width:200px">财经频道</option>
						<option style="width:200px">汽车频道</option>
						<option style="width:200px">电子频道</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>新闻来源：</td>
				<td><input type="text" name="newsSource" size="30"></td>
			</tr>
			<tr>
				<td>新闻作者：</td>
				<td><input type="text" name="newsAuthor" size="30"></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input type="text" name="newsCreateTime" value="<%=time%>"
					size="30" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" name="newsKeyword" size="30">
				</td>
			</tr>
			<tr>
			</tr>
		</table>
		<font color="red">（其中*项为必填项）</font><br> 内容*：<br>
		<textarea name="newsContent" rows="15" cols="80">
    		</textarea>
		<br> <input type="submit" name="check" value="发布">
	</form>
	<input type="submit" name="cancel" value="取消"
		onClick="window.location.href='toEditor'">
</body>
</html>

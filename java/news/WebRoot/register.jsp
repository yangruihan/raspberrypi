<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <form action="register" name="toregister" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<%
				String username = request.getParameter("name");
				if (username != null) {
					out.print("<td><input type=\"text\" name=\"name\" value=\""
						+ username + "\"/></td>");
				} else {
					out.print("<td><input type=\"text\" name=\"name\"/></td>");
				}
			%>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>重复密码：</td>
			<td><input type="password" name="password2"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="click" value="提交">
			</td>
		</tr>
	</table>
</form>

<%
	String result = (String) request.getAttribute("result");
	if (result != null) {
		out.print("<font color=\"#FF0000\">" + result + "</font>");
	}
%>
  </body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <h1>用户登录</h1>
    <br>
    <hr>
    <form action="request.jsp" name="loginForm" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="username"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="password"/></td>
    		</tr>
    		<tr>
    			<td>爱好：</td>
    			<td>
    			<input type="checkbox" name="favorites" value="read"/>看书
    			<input type="checkbox" name="favorites" value="internet"/>上网
    			<input type="checkbox" name="favorites" value="music"/>音乐
    			<input type="checkbox" name="favorites" value="sleep"/>睡觉</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			<input type="submit" name="click"/></td>
			</tr>
    	</table>
    </form>
    
    <a href="request.jsp?username=张三">这是一个测试用URL</a>
    
  </body>
</html>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
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
    <h1>session机制</h1>
    <hr>
    <%
    	SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(session.getCreationTime());
        
        out.println("session创建时间：" + format.format(date) + "<br>");
        out.println("session ID：" + session.getId() + "<br>");
		
		// 设置参数        
        session.setAttribute("username", "admin");
    	session.setAttribute("password", "admin123");
    	session.setAttribute("age", 24);
    	
    	session.setMaxInactiveInterval(10);	// 设置session生命周期为10s
     %>
    用户名：<%= session.getAttribute("username") %><br>
    密码：<%=session.getAttribute("password") %><br>
    年龄：<%=session.getAttribute("age") %><br>
    <a href="session2.jsp"  target="_blank">跳转到session2页面</a><br>
  </body>
</html>

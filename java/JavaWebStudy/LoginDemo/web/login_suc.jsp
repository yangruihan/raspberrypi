<%@ page import="com.yrh.model.User" %><%--
  Created by IntelliJ IDEA.
  User: yrh
  Date: 16-2-16
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>登录成功</h1>
<jsp:useBean id="user" class="com.yrh.model.User" scope="page"/>
<jsp:setProperty name="user" property="*"/>
欢迎你，<jsp:getProperty name="user" property="username"/>
</body>
</html>
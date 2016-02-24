<%--
  Created by IntelliJ IDEA.
  User: Yrh
  Date: 2016/2/24
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post" name="loginForm">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        爱好1：<input type="text" name="favorites[0]"> <br>
        爱好2：<input type="text" name="favorites[1]"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>

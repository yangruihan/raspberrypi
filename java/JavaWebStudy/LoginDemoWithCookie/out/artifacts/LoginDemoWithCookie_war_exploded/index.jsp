<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: yrh
  Date: 16-2-16
  Time: 下午5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Demo With Cookie</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie c :
                cookies) {
            if ("username".equals(c.getName())) {
                username = URLDecoder.decode(c.getValue(), "utf-8");
            }
            if ("password".equals(c.getName())) {
                password = URLDecoder.decode(c.getValue(), "utf-8");
            }
        }
    }
%>
<form name="loginForm" action="dologin.jsp" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="<%=username%>"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" value="<%=password%>"></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="isRemembered">记住我</td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="button" value="取消"></td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: yrh
  Date: 16-2-16
  Time: 下午5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细信息</title>
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
用户名：<%=username%>
密码：<%=password%>
</body>
</html>

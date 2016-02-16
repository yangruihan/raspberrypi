<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yrh
  Date: 16-2-16
  Time: 下午5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String[] isRemembered = request.getParameterValues("isRemembered");
    // 勾选记住我
    if (isRemembered != null && isRemembered.length > 0) {
        String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
        String password = URLEncoder.encode(request.getParameter("password"), "utf-8");

        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        usernameCookie.setMaxAge(10000);
        passwordCookie.setMaxAge(10000);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
    } else {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c :
                    cookies) {
                if ("username".equals(c.getName()) || "password".equals(c.getName())) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
    }
%>
<a href="detail.jsp">点我查看详细信息</a>
</body>
</html>

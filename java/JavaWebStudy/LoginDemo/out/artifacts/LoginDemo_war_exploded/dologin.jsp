<%--
  Created by IntelliJ IDEA.
  User: yrh
  Date: 16-2-16
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<jsp:useBean id="user" class="com.yrh.model.User" scope="page"/>
<jsp:useBean id="userDao" class="com.yrh.dao.UserDao" scope="page"/>
<jsp:setProperty name="user" property="*"/>
<%
    if (userDao.check(user)) {
        request.getRequestDispatcher("login_suc.jsp").forward(request, response);
    } else {
        response.sendRedirect("login_fail.jsp");
    }
%>
</body>
</html>

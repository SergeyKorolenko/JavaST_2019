<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 28.11.2019
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page</title>
</head>
<body>
<jsp:useBean id="user" scope="request" class="by.korolenko.adsdesk.bean.User"/>
${user}
</body>
</html>

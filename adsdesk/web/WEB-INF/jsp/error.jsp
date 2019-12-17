<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 20.11.2019
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>404</title>
    <meta charset="utf-8">

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <!-- Page Content -->
    <h1 class="display-1">404</h1>
    <p class="lead">Page not found. You can <a
            href="<c:url value="/main.html"/>">return to the main page</a>.</p>

</div>
</body>
</html>

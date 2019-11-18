<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 17.11.2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category list</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>subcategory name</th>
    </tr>
    <jsp:useBean id="lst" scope="request" type="java.util.List"/>
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <th><c:out value="${ elem.id }"/></th>
            <th><c:out value="${ elem.name }"/></th>
            <th><c:out value="${ elem.parent.id }"/></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>

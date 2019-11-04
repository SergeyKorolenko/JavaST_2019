<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 03.11.2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of gems</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Number</th>
        <th>Name</th>
        <th>Origin</th>
        <th>Color</th>
        <th>Transparency</th>
        <th>Cut method</th>
        <th>Faces</th>
        <th>Production date</th>
        <th>Carats/weight</th>
    </tr>
    <jsp:useBean id="lst" scope="request" type="java.util.List"/>
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <th><c:out value="${ elem.number }"/></th>
            <th><c:out value="${ elem.name }"/></th>
            <th><c:out value="${ elem.origin }"/></th>
            <th><c:out value="${ elem.visualParameters.color }"/></th>
            <th><c:out value="${ elem.visualParameters.transparency }"/></th>
            <th><c:out value="${ elem.visualParameters.cutMethod }"/></th>
            <th><c:out value="${ elem.visualParameters.faces }"/></th>
            <th><c:out value="${ elem.productionDate }"/></th>
            <th><c:out value="${ elem }"/></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>

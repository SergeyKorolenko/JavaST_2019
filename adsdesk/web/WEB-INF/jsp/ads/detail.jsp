<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.12.2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ads detail</title>
</head>
<body>
<jsp:useBean id="ads" scope="request" class="by.korolenko.adsdesk.bean.Ads"/>
${ads}
<jsp:useBean id="comments" scope="request" type="java.util.List"/>
<c:forEach var="elem" items="${comments}" varStatus="status">
    ${elem.text}
</c:forEach>
</body>
</html>

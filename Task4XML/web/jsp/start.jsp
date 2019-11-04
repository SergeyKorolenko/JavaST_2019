<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 03.11.2019
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<form action="controller" method="post" enctype="multipart/form-data">
    <p>Load xml file</p>
    <p><input type="file" name="file">
    <p>Choose parser</p>
    <p><select name="parser">
        <option>DOM</option>
        <option>SAX</option>
        <option>STAX</option>
    </select></p>
    <p><input type="submit" value="Parse"></p>
</form>
</body>
</html>

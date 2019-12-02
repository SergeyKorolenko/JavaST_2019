<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 24.11.2019
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/data/fontawesome-free/css/all.min.css"/>"
          rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
</head>
<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header text-center">Login</div>
        <div class="card-body">
            <c:url value="/login.html" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <div class="form-group">
                    <div class="form-label-group">
                        <input id="inputEmail" class="form-control"
                               placeholder="Email address" required="required"
                               autofocus="autofocus" name="login">
                        <label for="inputEmail">Login</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="inputPassword"
                               class="form-control" placeholder="Password"
                               required="required" name="password">
                        <label for="inputPassword">Password</label>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <div class="text-center">
                <c:url value="/registration.forward" var="registrationUrl"/>
                <a class="d-block small mt-3" href="${registrationUrl}">Register
                    an
                    Account</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/data/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/data/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/data/jquery-easing/jquery.easing.min.js"/>"></script>

</body>
</html>

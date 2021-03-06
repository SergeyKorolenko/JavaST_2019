<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 24.11.2019
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="locale.text"/>
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
        <div class="card-header text-center"><fmt:message
                key="label.login"/></div>
        <div class="card-body">
            <form action="<c:url value="/login.html"/>" method="post">
                <div class="form-group">
                    <div class="form-label-group">
                        <input id="inputEmail" class="form-control"
                               placeholder="Email address" required="required"
                               autofocus="autofocus" name="login">
                        <label for="inputEmail"><fmt:message
                                key="label.logIn"/></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="inputPassword"
                               class="form-control" placeholder="Password"
                               required="required" name="password">
                        <label for="inputPassword"><fmt:message
                                key="label.password"/></label>
                    </div>
                </div>
                <span class="text-danger">
                    <div>
                        ${requestScope.message}
                    </div>
                </span>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary"><fmt:message
                            key="label.login"/>
                    </button>
                </div>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3"
                   href="<c:url value="/page/register.html"/>">Register an
                    Account</a>
                <a class="d-block small mt-3"
                   href="<c:url value="/main.html"/>">Return to the main
                    page</a>
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

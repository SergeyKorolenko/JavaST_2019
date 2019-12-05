<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 24.11.2019
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/data/fontawesome-free/css/all.min.css"/>"
          rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
</head>
<body class="bg-dark">
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header text-center">Register an Account</div>
        <div class="card-body">
            <c:url value="/register.html" var="registerUrl"/>
            <form action="${registerUrl}" method="post">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="name"
                                       class="form-control"
                                       placeholder="First name"
                                       required="required"
                                       autofocus="autofocus">
                                <label for="name">Name</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="login"
                                       class="form-control"
                                       placeholder="Last name"
                                       required="required">
                                <label for="login">Login</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="inputEmail"
                                       class="form-control"
                                       placeholder="First name"
                                       required="required"
                                       autofocus="autofocus">
                                <label for="inputEmail">Email</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="phone"
                                       class="form-control input-medium bfh-phone"
                                       placeholder="Last name"
                                       data-format="+375 (dd) ddd-dd-dd"
                                       required="required">
                                <label for="phone">Phone</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="password" id="inputPassword"
                                       class="form-control"
                                       placeholder="Password"
                                       required="required">
                                <label for="inputPassword">Password</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="password" id="confirmPassword"
                                       class="form-control"
                                       placeholder="Confirm password"
                                       required="required">
                                <label for="confirmPassword">Confirm
                                    password</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register
                    </button>
                </div>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3"
                   href="<c:url value="/page/login.html"/>">Login Page</a>
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

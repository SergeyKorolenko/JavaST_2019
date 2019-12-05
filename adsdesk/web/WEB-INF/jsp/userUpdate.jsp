<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.12.2019
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/data/fontawesome-free/css/all.min.css"/>"
          rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header text-center">Register an Account</div>
        <div class="card-body">
            <form action="<c:url value="/user/save.html"/>" method="post">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="name"
                                       class="form-control"
                                       placeholder="First name"
                                       required="required"
                                       autofocus="autofocus"
                                       value="${requestScope.user.name}">
                                <label for="name">Name</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="surname"
                                       class="form-control"
                                       placeholder="Last name">
                                <label for="surname">Surname</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Save
                    </button>
                </div>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3"
                   href="<c:url value="/main.html"/>">Return to the main
                    page</a>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/data/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/data/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/data/jquery-easing/jquery.easing.min.js"/>"></script>
</body>
</html>

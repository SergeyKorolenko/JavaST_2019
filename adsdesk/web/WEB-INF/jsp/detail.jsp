<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.12.2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Detail page</title>

    <link href="<c:url value="/data/fontawesome-free/css/all.min.css"/>"
          rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="<c:url value="/data/datatables/dataTables.bootstrap4.css"/>"
          rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.min.css"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/mystyle.css"/>" rel="stylesheet">

    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous">

</head>
<body id="page-top">

<c:import url="navbar.jsp"/>

<div id="wrapper">

    <div id="content-wrapper">

        <div class="container-fluid">
            <jsp:useBean id="ads" scope="request"
                         class="by.korolenko.adsdesk.bean.Ads"/>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${ads.heading}</h5>
                    <p class="card-text">${ads.text}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${ads.price}</li>
                    <li class="list-group-item">${ads.registerDate}</li>
                    <li class="list-group-item">${ads.bargain}</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>

            <div class="container">
                <jsp:useBean id="comments" scope="request"
                             type="java.util.List"/>
                <c:forEach var="elem" items="${comments}"
                           varStatus="status">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-2">
                                    <img src="https://image.ibb.co/jw55Ex/def_face.jpg"
                                         class="img img-rounded img-fluid"/>
                                    <p class="text-secondary text-center">${elem.addedDate}</p>
                                </div>
                                <div class="col-md-10">
                                    <p>
                                        <a class="float-left"
                                           href="#"><strong>${elem.user.id}</strong></a>
                                    </p>
                                    <div class="clearfix"></div>
                                    <p>${elem.comment}</p>
                                    <c:if test="${sessionScope.authorizedUser.id == elem.user.id}">
                                        <p>
                                            <a class="float-right btn text-white btn-success">
                                                <em class="fa fa-edit"></em>
                                                Edit</a>
                                        </p>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->

    </div>
    <!-- /.content-wrapper -->

</div>

<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <em class="fas fa-angle-up"></em>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to
                    Leave?</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to
                end your current session.
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button"
                        data-dismiss="modal">Cancel
                </button>
                <a class="btn btn-primary" href="<c:url value="/logout.html"/>">Log
                    out</a>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/data/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/data/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/data/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin.min.js"/>"></script>

</body>
</html>
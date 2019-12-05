<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 17.11.2019
  Time: 13:43
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
    <title>Main page</title>

    <link href="<c:url value="/data/fontawesome-free/css/all.min.css"/>"
          rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="<c:url value="/data/datatables/dataTables.bootstrap4.css"/>"
          rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.min.css"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
</head>
<body id="page-top">

<c:import url="fragment/navbar.jsp"/>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
               role="button" data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false">
                <em class="fas fa-fw fa-folder"></em>
                <span>Categories</span>
            </a>
            <jsp:useBean id="categoryList" scope="request"
                         type="java.util.List"/>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <c:forEach var="elem" items="${categoryList}">
                    <a class="dropdown-item"
                       href="<c:url value="/search/ads/category.html"/>?id=${elem.id}">${elem.categoryName}</a>
                </c:forEach>
            </div>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">
            <!-- Icon Cards-->
            <jsp:useBean id="adsList" scope="request" type="java.util.List"/>
            <c:forEach var="elem" items="${adsList}" varStatus="status">
                <div class="row">

                    <!-- Area Chart -->
                    <div class="col-12">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary">${elem.heading}</h6>
                                <span>${elem.price}</span>
                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <img src="#" alt="" class="img-thumbnail">
                                    ${elem.text}
                            </div>
                            <div class="card-footer py-3 d-flex flex-row align-items-center justify-content-between">
                                <span>${elem.registerDate}</span>
                                <form action="<c:url value="/ads/detail.html"/>"
                                      method="post">
                                    <div class="text-center">
                                        <button type="submit"
                                                class="btn btn-primary"
                                                value="${elem.id}"
                                                name="adsDetail">View details
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


            <nav aria-label="Navigation for ads">
                <ul class="pagination">
                    <c:if test="${requestScope.currentPage != 1}">
                        <li class="page-item"><a class="page-link"
                                                 href="<c:url value="/main.html"/>?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${requestScope.currentPage-1}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${requestScope.noOfPages}"
                               var="i">
                        <c:choose>
                            <c:when test="${requestScope.currentPage eq i}">
                                <li class="page-item active"><a
                                        class="page-link">
                                        ${i} <span
                                        class="sr-only">(current)</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link"
                                                         href="<c:url value="/main.html"/>?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
                        <li class="page-item"><a class="page-link"
                                                 href="<c:url value="/main.html"/>?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${requestScope.currentPage+1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright © Sergei Korolenko 2019</span>
                </div>
            </div>
        </footer>

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

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/data/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/data/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/data/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin.min.js"/>"></script>

</body>
</html>

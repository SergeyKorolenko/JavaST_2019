<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 06.12.2019
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="locale.text"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Main page</title>
    <c:import url="link.jsp"/>
</head>

<body class="grey lighten-3" id="page-top">

<!--Main Navigation-->
<c:import url="navbar.jsp"/>
<!--Main Navigation-->

<!--Main layout-->
<main class="mt-5 pt-5">
    <div class="container">

        <!--Section: Post-->
        <section class="mt-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-md-3 mb-4">

                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">Categories</div>
                        <jsp:useBean id="categoryList" scope="request"
                                     type="java.util.List"/>
                        <!--Card content-->
                        <div class="card-body">

                            <c:forEach var="elem" items="${categoryList}">
                                <a class="dropdown-item"
                                   href="<c:url value="/search/ads/category.html"/>?id=${elem.id}">${elem.categoryName}</a>
                            </c:forEach>
                        </div>

                    </div>
                    <c:if test="${requestScope.subcategoryList != null && not empty requestScope.subcategoryList}">
                        <!--Card : Dynamic content wrapper-->
                        <div class="card mb-4 text-center wow fadeIn">

                            <div class="card-header">Subcategories</div>
                            <jsp:useBean id="subcategoryList" scope="request"
                                         type="java.util.List"/>
                            <!--Card content-->
                            <div class="card-body">

                                <c:forEach var="el" items="${subcategoryList}">
                                    <a class="dropdown-item"
                                       href="<c:url value="/search/ads/subcategory.html"/>?id=${el.id}">${el.categoryName}</a>
                                </c:forEach>

                            </div>

                        </div>
                        <!--/.Card : Dynamic content wrapper-->
                    </c:if>
                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">Filters</div>

                        <!--Card content-->
                        <div class="card-body">

                            <!-- Default form login -->
                            <form>


                            </form>
                            <!-- Default form login -->

                        </div>

                    </div>
                    <!--/.Card : Dynamic content wrapper-->
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-md-9 mb-4">
                    <jsp:useBean id="adsList" scope="request"
                                 type="java.util.List"/>
                    <c:forEach var="elem" items="${adsList}">
                        <!--Card-->
                        <div class="card mb-4 wow fadeIn">

                            <div class="card-header font-weight-bold">
                                <span>${elem.heading}</span>
                                <span>${elem.price}</span>
                            </div>

                            <!--Card content-->
                            <div class="card-body">

                                <div class="media d-block d-md-flex mt-3">
                                    <img class="d-flex mb-3 mx-auto z-depth-1"
                                         src="<c:url value="/img/cat.jpg"/>"
                                         alt="Generic placeholder image"
                                         style="width: 100px;">
                                    <div class="media-body text-center text-md-left ml-md-3 ml-0">
                                            ${elem.text}
                                    </div>
                                </div>

                            </div>

                            <div class="card-footer font-weight-bold d-flex flex-row align-items-center justify-content-between">
                                <span>${elem.registerDate}</span>
                                <a class="btn btn-primary"
                                   href="<c:url value="/ads/detail.html"/>?adsId=${elem.id}">View
                                    details</a>
                            </div>

                        </div>
                        <!--/.Card-->
                    </c:forEach>
                    <!--/.Pagination-->
                    <nav aria-label="Navigation for ads"
                         class="d-flex justify-content-center">
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
                                        <li class="page-item"><a
                                                class="page-link"
                                                href="<c:url value="/main.html"/>?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${i}">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="<c:url value="/main.html"/>?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${requestScope.currentPage+1}">Next
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

        </section>
        <!--Section: Post-->

    </div>
</main>
<!--Main layout-->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <em class="fas fa-angle-up"></em>
</a>

<!--Footer-->
<c:import url="footer.jsp"/>
<!--/.Footer-->

<c:import url="script.jsp"/>
</body>

</html>


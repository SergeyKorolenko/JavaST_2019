<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 04.12.2019
  Time: 23:29
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
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add ads page</title>
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
                <div class="col-md-2 mb-4">

                </div>

                <!--Grid column-->
                <div class="col-md-8 mb-4">

                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">Form for adding ads</div>

                        <!--Card content-->
                        <div class="card-body">

                            <!-- Default form login -->
                            <form action="<c:url value="/ads/add.html"/>"
                                  method="post">
                                <input type="hidden" name="userId"
                                       value="${sessionScope.authorizedUser.id}">
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-12">
                                            <div class="form-label-group">
                                                <input type="text" id="heading"
                                                       class="form-control"
                                                       placeholder="Heading"
                                                       required="required"
                                                       autofocus="autofocus"
                                                       name="heading">
                                                <label for="heading">Heading</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-12">
                                            <div class="form-label-group">
                                                <input type="text" id="mainText"
                                                       class="form-control"
                                                       placeholder="Text"
                                                       required="required"
                                                       autofocus="autofocus"
                                                       name="mainText">
                                                <label for="mainText">Text</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-12">
                                            <div class="form-label-group">
                                                <input type="number" id="price"
                                                       class="form-control"
                                                       placeholder="Price"
                                                       required="required"
                                                       autofocus="autofocus"
                                                       name="price">
                                                <label for="price">Price</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="checkbox"
                                               class="form-check-input"
                                               name="bargain" value="0">Bargain
                                    </label>
                                </div>
                                <div class="form-group">
                                    <jsp:useBean id="localities" scope="request"
                                                 type="java.util.List"/>
                                    <label for="localitySelect">Locality</label>
                                    <select class="form-control"
                                            id="localitySelect"
                                            name="localitySelect">
                                        <c:forEach var="elem"
                                                   items="${localities}">
                                            <option value="${elem.id}">${elem.localityName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <jsp:useBean id="categories" scope="request"
                                                 type="java.util.List"/>
                                    <label for="categorySelect">Category</label>
                                    <select class="form-control"
                                            id="categorySelect"
                                            name="categorySelect">
                                        <c:forEach var="elem"
                                                   items="${categories}">
                                            <option value="${elem.id}">${elem.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="text-center">
                                    <button type="submit"
                                            class="btn btn-primary">Add ads
                                    </button>
                                </div>
                            </form>
                            <!-- Default form login -->

                        </div>

                    </div>
                    <!--/.Card : Dynamic content wrapper-->


                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

            <!--Grid column-->
            <div class="col-md-2 mb-4">

            </div>

        </section>
        <!--Section: Post-->

    </div>
</main>
<!--Main layout-->

<!--Footer-->
<c:import url="footer.jsp"/>
<!--/.Footer-->
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <em class="fas fa-angle-up"></em>
</a>

<c:import url="script.jsp"/>
</body>
</html>

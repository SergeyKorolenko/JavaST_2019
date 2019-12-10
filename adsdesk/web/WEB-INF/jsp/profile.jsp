<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 28.11.2019
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Profile page</title>
    <c:import url="link.jsp"/>
</head>
<body id="page-top">

<c:import url="navbar.jsp"/>

<jsp:useBean id="user" scope="request"
             class="by.korolenko.adsdesk.bean.User"/>

<!--Main layout-->
<main class="mt-5 pt-5">
    <div class="container">

        <!--Section: Post-->
        <section class="mt-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-md-3 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="view overlay">
                            <img src="<c:url value="/img/profile.png"/>"
                                 class="card-img-top"
                                 alt="">
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">${user.surname} ${user.name} ${user.patronymic}</h4>
                            <!--Text-->
                            <p class="card-text">Phone: ${user.phone}</p>
                            <p class="card-text">Email: ${user.email}</p>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

                <div class="col-md-3 mb-4"></div>

                <!--Grid column-->
                <div class="col-md-6 mb-4">

                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">Edit profile</div>

                        <!--Card content-->
                        <div class="card-body">

                            <!-- Default form login -->
                            <form action="<c:url value="/user/edit/profile.html"/>"
                                  method="post">

                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input id="name" class="form-control"
                                               placeholder="Name"
                                               required="required"
                                               autofocus="autofocus" name="name"
                                               value="${user.name}">
                                        <label for="name">name</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input id="surname"
                                               class="form-control"
                                               placeholder="Surname"
                                               name="surname"
                                               value="${user.surname}">
                                        <label for="surname">Surname</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input id="patronymic"
                                               class="form-control"
                                               placeholder="Password"
                                               name="patronymic"
                                               value="${user.patronymic}">
                                        <label for="patronymic">Patronymic</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input id="phone" required="required"
                                               class="form-control"
                                               placeholder="Phone"
                                               name="phone"
                                               value="${user.phone}">
                                        <label for="phone">Phone</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="email" id="email"
                                               required="required"
                                               class="form-control"
                                               placeholder="Email"
                                               name="email"
                                               value="${user.email}">
                                        <label for="email">Email</label>
                                    </div>
                                </div>
                                <div class="text-center mt-4">
                                    <button class="btn btn-info btn-md"
                                            type="submit">Update profile
                                    </button>
                                </div>

                            </form>
                            <!-- Default form login -->

                        </div>

                    </div>
                    <!--/.Card : Dynamic content wrapper-->

                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">Change password</div>

                        <!--Card content-->
                        <div class="card-body">

                            <!-- Default form login -->
                            <form action="<c:url value="/user/change/password.html"/>"
                                  method="post">

                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="password" id="oldPassword"
                                               class="form-control"
                                               placeholder="Old password"
                                               required="required"
                                               autofocus="autofocus"
                                               name="oldPassword">
                                        <label for="oldPassword">Old
                                            password</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="password" id="newPassword"
                                               class="form-control"
                                               placeholder="New password"
                                               required="required"
                                               name="newPassword">
                                        <label for="newPassword">New
                                            password</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="password"
                                               id="confNewPassword"
                                               class="form-control"
                                               placeholder="Password"
                                               required="required"
                                               name="confNewPassword">
                                        <label for="confNewPassword">Confirm new
                                            password</label>
                                    </div>
                                </div>
                                <div class="text-center mt-4">
                                    <button class="btn btn-info btn-md"
                                            type="submit">Change password
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
            <!--Grid row-->
            <div class="row">
                <jsp:useBean id="userAdsList" scope="request"
                             type="java.util.List"/>
                <c:forEach var="elem" items="${userAdsList}">
                    <!--Grid column-->
                    <div class="col-md-6 mb-4">
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
                                <form action="<c:url value="/ads/detail.html"/>?adsId=${elem.id}"
                                      method="post">
                                    <button type="submit"
                                            class="btn btn-primary"
                                            value="${elem.id}"
                                            name="adsDetail">View details
                                    </button>
                                </form>
                                <form action="<c:url value="/ads/delete.html"/>"
                                      method="post">
                                    <input type="hidden" name="adsId"
                                           value="${elem.id}">
                                    <button type="submit"
                                            class="btn btn-red"
                                            value="${elem.id}"
                                            name="adsDetail">Delete
                                    </button>
                                </form>
                            </div>

                        </div>
                        <!--/.Card-->


                    </div>
                    <!--Grid column-->
                </c:forEach>

            </div>
            <!--Grid row-->
        </section>
        <!--Section: Post-->

    </div>
</main>
<!--Main layout-->

<c:import url="footer.jsp"/>
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

<c:import url="script.jsp"/>
</body>
</html>

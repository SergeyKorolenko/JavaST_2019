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
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Detail page</title>
    <c:import url="link.jsp"/>
</head>
<body id="page-top">

<c:import url="navbar.jsp"/>

<!--Main layout-->
<main class="mt-5 pt-5">
    <div class="container">

        <!--Section: Post-->
        <section class="mt-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-md-8 mb-4">
                    <jsp:useBean id="ads" scope="request"
                                 type="by.korolenko.adsdesk.bean.Ads"/>
                    <!--Card-->
                    <div class="card mb-4 wow fadeIn">

                        <div class="card-header font-weight-bold">
                            <span>${ads.heading}</span>
                            <span>${ads.price}</span>
                        </div>

                        <!--Card content-->
                        <div class="card-body">

                            <div class="media d-block d-md-flex mt-3">
                                <img class="d-flex mb-3 mx-auto z-depth-1"
                                     src="<c:url value="/img/cat.jpg"/>"
                                     alt="Generic placeholder image"
                                     style="width: 100px;">
                                <div class="media-body text-center text-md-left ml-md-3 ml-0">
                                    ${ads.text}
                                </div>
                            </div>

                        </div>

                    </div>
                    <!--/.Card-->

                    <!--Featured Image-->
                    <div class="card mb-4 wow fadeIn">

                        <img src="https://mdbootstrap.com/img/Photos/Slides/img%20(144).jpg"
                             class="img-fluid" alt="">

                    </div>
                    <!--/.Featured Image-->

                    <!--Card-->
                    <div class="card mb-4 wow fadeIn">

                        <!--Card content-->
                        <div class="card-body text-center">

                            <p class="h5 my-4">What is MDB?</p>

                            <p>MDB is world's most popular Material Design
                                framework for building responsive, mobile-first
                                websites and apps.</p>

                            <h5 class="my-4">
                                <strong>MDB - trusted by 400 000 + developers
                                    &amp; designers</strong>
                            </h5>

                            <!-- Logo carousel -->
                            <div id="carouselExampleSlidesOnly"
                                 class="carousel slide" data-ride="carousel"
                                 data-interval="1800">
                                <div class="carousel-inner">
                                    <!-- First slide -->
                                    <div class="carousel-item">
                                        <!--Grid row-->
                                        <div class="row">

                                            <!--First column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/nike.png"
                                                     class="img-fluid px-4"
                                                     alt="Nike - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/First column-->

                                            <!--Second column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/amazon.png"
                                                     class="img-fluid px-4"
                                                     alt="Amazon - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Second column-->

                                            <!--Third column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/sony.png"
                                                     class="img-fluid px-4"
                                                     alt="Sony - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Third column-->

                                            <!--Fourth column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/samsung.png"
                                                     class="img-fluid px-4"
                                                     alt="Samsung - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Fourth column-->

                                        </div>
                                        <!--/Grid row-->
                                    </div>
                                    <!-- First slide -->

                                    <!-- Second slide -->
                                    <div class="carousel-item active carousel-item-left">
                                        <!--Grid row-->
                                        <div class="row">

                                            <!--First column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/airbus.png"
                                                     class="img-fluid px-4"
                                                     alt="Airbus - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/First column-->

                                            <!--Second column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/yahoo.png"
                                                     class="img-fluid px-4"
                                                     alt="Yahoo - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Second column-->

                                            <!--Third column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/deloitte.png"
                                                     class="img-fluid px-4"
                                                     alt="Deloitte - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Third column-->

                                            <!--Fourth column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/ge.png"
                                                     class="img-fluid px-4"
                                                     alt="GE - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Fourth column-->

                                        </div>
                                        <!--/Grid row-->
                                    </div>
                                    <!-- Second slide -->

                                    <!-- Third slide -->
                                    <div class="carousel-item carousel-item-next carousel-item-left">
                                        <!--Grid row-->
                                        <div class="row">

                                            <!--First column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/kpmg.png"
                                                     class="img-fluid px-4"
                                                     alt="KPMG - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/First column-->

                                            <!--Second column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/unity.png"
                                                     class="img-fluid px-4"
                                                     alt="Unity - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Second column-->

                                            <!--Third column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/ikea.png"
                                                     class="img-fluid px-4"
                                                     alt="Ikea - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Third column-->

                                            <!--Fourth column-->
                                            <div class="col-lg-3 col-md-6 d-flex align-items-center justify-content-center">
                                                <img src="https://mdbootstrap.com/img/logo/brands/aegon.png"
                                                     class="img-fluid px-4"
                                                     alt="Aegon - logo"
                                                     style="max-height: 40px">
                                            </div>
                                            <!--/Fourth column-->

                                        </div>
                                        <!--/Grid row-->
                                    </div>
                                    <!-- Third slide -->
                                </div>
                            </div>
                            <!-- Logo carousel -->


                        </div>

                    </div>
                    <!--/.Card-->
                    <jsp:useBean id="comments" scope="request"
                                 type="java.util.List"/>
                    <!--Comments-->
                    <div class="card card-comments mb-3 wow fadeIn">
                        <div class="card-header font-weight-bold">${requestScope.commentCount}
                            comments
                        </div>
                        <div class="card-body">
                            <c:forEach var="elem" items="${comments}">
                                <div class="media d-block d-md-flex mt-4">
                                    <img class="d-flex mb-3 mx-auto "
                                         src="<c:url value="/img/cat.jpg"/>"
                                         alt="Generic placeholder image">
                                    <div class="media-body text-center text-md-left ml-md-3 ml-0">
                                        <h5 class="mt-0 font-weight-bold">Miley
                                            Steward
                                        </h5>
                                            ${elem.comment}
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                    <!--/.Comments-->
                    <c:if test="${not empty sessionScope.authorizedUser}">
                        <!--Reply-->
                        <div class="card mb-3 wow fadeIn">
                            <div class="card-header font-weight-bold">Leave a
                                reply
                            </div>
                            <div class="card-body">

                                <!-- Default form reply -->
                                <form action="<c:url value="/add/comment.html"/>"
                                      method="post">
                                    <input type="hidden" name="userId"
                                           value="${sessionScope.authorizedUser.id}">
                                    <input type="hidden" name="adsId"
                                           value="${requestScope.ads.id}">
                                    <!-- Comment -->
                                    <div class="form-group">
                                        <label for="replyFormComment">Your
                                            comment</label>
                                        <textarea class="form-control"
                                                  id="replyFormComment"
                                                  rows="5"
                                                  name="comment"></textarea>
                                    </div>

                                    <div class="text-center mt-4">
                                        <button class="btn btn-info btn-md"
                                                type="submit">Post
                                        </button>
                                    </div>
                                </form>
                                <!-- Default form reply -->


                            </div>
                        </div>
                        <!--/.Reply-->
                    </c:if>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-md-4 mb-4">

                    <jsp:useBean id="user" scope="request"
                                 type="by.korolenko.adsdesk.bean.User"/>
                    <!--Card : Dynamic content wrapper-->
                    <div class="card mb-4 text-center wow fadeIn">

                        <div class="card-header">User data</div>

                        <!--Card content-->
                        <div class="card-body">
                            <ul>
                                <li>
                                    <span>Name: ${user.name}</span>
                                </li>

                                <c:if test="${not empty user.patronymic}">
                                    <li>
                                        <span>Patronymic: ${user.patronymic}</span>
                                    </li>
                                </c:if>
                                <li>
                                    <span>Phone: ${user.phone}</span>
                                </li>
                                <li>
                                    <span>Email: ${user.email}</span>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!--/.Card : Dynamic content wrapper-->

                </div>
                <!--Grid column-->

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
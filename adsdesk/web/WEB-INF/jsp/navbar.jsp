<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 05.12.2019
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="locale.text"/>
<!--Main Navigation-->
<header>

    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <div class="container">

            <!-- Brand -->
            <a class="navbar-brand waves-effect"
               href="<c:url value="/main.html"/>">
                <strong class="blue-text"><fmt:message
                        key="label.logo"/></strong>
            </a>

            <!-- Collapse -->
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <!-- Links -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="form-inline my-2 my-lg-0"
                      action="<c:url value="/search/substring.html"/>">
                    <input class="form-control mr-sm-2" type="search"
                           placeholder="Search" aria-label="Search"
                           name="search">
                    <button class="btn btn-outline-success my-2 my-sm-0"
                            type="submit">Search
                    </button>
                </form>
                <!-- Left -->
                <ul class="navbar-nav mr-auto">
                </ul>
                <!-- Right -->
                <ul class="navbar-nav d-none d-md-flex">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#"
                           id="language"
                           data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false"><span
                                class="flag-icon flag-icon-gb"> </span> English</a>
                        <div class="dropdown-menu" onchange="submit()"
                             role="menu" aria-labelledby="language">
                            <a class="dropdown-item" role="menuitem"
                               href="?locale=en"><span
                                    class="flag-icon flag-icon-gb"> </span>
                                English</a>
                            <a class="dropdown-item" role="menuitem"
                               href="?locale=ru"><span
                                    class="flag-icon flag-icon-ru"> </span>
                                Russian</a>
                            <a class="dropdown-item" role="menuitem"
                               href="?locale=be"><span
                                    class="flag-icon flag-icon-by"> </span>
                                Belarusian</a>
                        </div>
                    </li>

                    <c:choose>
                        <c:when test="${!empty sessionScope.authorizedUser}">
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#"
                                   id="userDropdown"
                                   role="button" data-toggle="dropdown"
                                   aria-haspopup="true"
                                   aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Hello, ${sessionScope.authorizedUser.name}</span>
                                    <em class="fas fa-user-circle fa-fw"></em>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item"
                                       href="<c:url value="/user/profile.html"/>?id=${sessionScope.authorizedUser.id}">
                                        <em class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></em>Profile
                                    </a>
                                    <a class="dropdown-item"
                                       href="<c:url value="/page/ads/add.html"/>">
                                        <em class="fas fa-plus fa-sm fa-fw mr-2 text-gray-400"></em>Add
                                        ads</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#"
                                       data-toggle="modal"
                                       data-target="#logoutModal">
                                        <em class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></em>Log
                                        out
                                    </a>
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="<c:url value="/page/login.html"/>">
                                    <em class="fas fa-sign-in-alt fa-sm fa-fw mr-2 text-gray-400"></em><fmt:message
                                        key="label.login"/>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="<c:url value="/page/register.html"/>">
                                    <em class="text-gray-400"></em><fmt:message
                                        key="label.register"/>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>

            </div>

        </div>
    </nav>
    <!-- Navbar -->

</header>

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

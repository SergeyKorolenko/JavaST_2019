<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 05.12.2019
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
    <a class="navbar-brand mr-1" href="<c:url value="/main.html"/>">Ads desk</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0"
            id="sidebarToggle" href="#">
        <em class="fas fa-bars"></em>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search for..."
                   aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                    <em class="fas fa-search"></em>
                </button>
            </div>
        </div>
    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">

        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
        <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown"
               role="button" data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false">
                <em class="fas fa-search fa-fw"></em>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                 aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                    <div class="input-group">
                        <input type="text"
                               class="form-control bg-light border-0 small"
                               placeholder="Search for..." aria-label="Search"
                               aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <em class="fas fa-search fa-sm"></em>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </li>


        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown09"
               data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false"><span
                    class="flag-icon flag-icon-us"> </span> English</a>
            <div class="dropdown-menu" aria-labelledby="dropdown09">
                <a class="dropdown-item" href="#"><span
                        class="flag-icon flag-icon-ru"> </span> Russian</a>
                <a class="dropdown-item" href="#"><span
                        class="flag-icon flag-icon-by"> </span> Belarusian</a>
            </div>
        </li>
        <c:choose>
            <c:when test="${!empty sessionScope.authorizedUser}">
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#"
                       id="userDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small">Hello,${sessionScope.authorizedUser.name}</span>
                        <em class="fas fa-user-circle fa-fw"></em>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right"
                         aria-labelledby="userDropdown">
                        <a class="dropdown-item"
                           href="<c:url value="/user/profile.html"/>?id=${sessionScope.authorizedUser.id}">
                            <em class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></em>Profile
                        </a>
                        <a class="dropdown-item"
                           href="<c:url value="/user/comment.html"/>">
                            <em class="fas fa-comment-alt fa-sm fa-fw mr-2 text-gray-400"></em>Comments</a>
                        <a class="dropdown-item"
                           href="<c:url value="/user/update.html"/>">
                            <em class="fas fa-edit fa-sm fa-fw mr-2 text-gray-400"></em>Edit
                            profile</a>
                        <a class="dropdown-item"
                           href="<c:url value="/user/ads/add.html"/>">Add
                            ads</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal"
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
                        <em class="fas fa-sign-in-alt fa-sm fa-fw mr-2 text-gray-400"></em>Log
                        in
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="<c:url value="/page/register.html"/>">
                        <em class="text-gray-400"></em>Register
                    </a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

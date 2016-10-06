<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header class="main-header">
    <!-- Logo -->
    <a href="${home}" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini">${projectTitleShort}</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">${projectTitle}</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${res}dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><sec:authentication property="principal.agent.name"/></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${res}dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                <sec:authentication property="principal.username"/><br>
                                <sec:authentication property="principal.agent.name"/>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Настройки профиля</a>
                            </div>
                            <div class="pull-right">
                                <form method="post" action="${logoutUrl}">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="submit" class="btn btn-default btn-flat" value="Выход">
                                </form>
                                <%--<a href="${logoutUrl}" class="btn btn-default btn-flat">Sign out</a>--%>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">ГЛАВНОЕ МЕНЮ</li>
            <li class="treeview">
                <a href="${root}agent/">
                    <i class="fa fa-table"></i> <span>Точки рекламы</span>
                    <span class="pull-right-container"></span>
                </a>
            </li>
            <li class="treeview">
                <a href="${root}agent/owner/">
                    <i class="glyphicon glyphicon-user"></i> <span>Владельцы</span>
                    <span class="pull-right-container"></span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
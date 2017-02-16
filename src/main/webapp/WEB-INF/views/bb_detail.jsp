<%@ page import="com.sotas.billboard05.dto.Month" %>
<%@ page import="com.sotas.billboard05.dto.TimetableSideDto" %>
<%@ page import="com.sotas.billboard05.entity.Timetable" %>
<%@ page import="com.sotas.billboard05.utils.I18nUtils" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="parts/init.jsp"/>

<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Aviators - byaviators.com">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="shortcut icon" href="${res}meforest/img/favicon.png" type="image/png">
    <link rel="stylesheet" href="${res}meforest/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${res}meforest/css/bootstrap-responsive.css" type="text/css">
    <link rel="stylesheet" href="${res}meforest/libraries/chosen/chosen.css" type="text/css">
    <link rel="stylesheet" href="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.css" type="text/css">
    <link rel="stylesheet" href="${res}meforest/libraries/jquery-ui-1.10.2.custom/css/ui-lightness/jquery-ui-1.10.2.custom.min.css" type="text/css">
    <link rel="stylesheet" href="${res}meforest/css/realia-blue.css" type="text/css" id="color-variant-default">
    <link rel="stylesheet" href="#" type="text/css" id="color-variant">
    <link href="${res}/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
    <title>Realia | HTML Template</title>
    <script>
        window.myrespath = "${res}";

        window.billboards = [
            {"id": ${billboard.id}, "position": [${billboard.location}], "address": "${billboard.address}"},
        ];
        function show_dialog(rowId) {
            BootstrapDialog.confirm({
                title: 'Заказ',
                message: $('<div class="input-append"><input id="phoneField" type="text" placeholder="Телефон" value="+7"/></div><div><textarea id="clientCommentField" type="text" placeholder="Примечание"/></div>'),
                callback: function(result) {
                    if(result) {
                        var phone = $("#phoneField").val();
                        var clientComment = $("#clientCommentField").val();
                        if(phone.length >= 10) {
                            if(clientComment.length > 0) {
                                $("#comment_" + rowId).val(clientComment);
                            }
                            $("#phone_" + rowId).val(phone);
                            $("#form_" + rowId).submit();
                        } else {
                            alert("Неверный номер телефона.")
                        }
                    }
                }
            });
        }
    </script>
</head>
<body>
<div id="wrapper-outer" >
    <div id="wrapper">
        <div id="wrapper-inner">
            <!-- BREADCRUMB -->
            <div class="breadcrumb-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <ul class="breadcrumb pull-left">
                                <li><a href="${root}">Главная</a></li>
                            </ul><!-- /.breadcrumb -->

                            <div class="account pull-right">
                                <ul class="nav nav-pills">
                                    <li><a href="${root}/agent/">Вход</a></li>
                                </ul>
                            </div>
                        </div><!-- /.span12 -->
                    </div><!-- /.row -->
                </div><!-- /.container -->
            </div><!-- /.breadcrumb-wrapper -->

            <!-- HEADER -->
            <div id="header-wrapper">
                <div id="header">
                    <div id="header-inner">
                        <div class="container">
                            <div class="navbar">
                                <div class="navbar-inner">
                                    <div class="row">
                                        <div class="logo-wrapper span4">
                                            <a href="#nav" class="hidden-desktop" id="btn-nav">Toggle navigation</a>

                                            <div class="logo">
                                                <a href="index.html" title="Home">
                                                    <img src="${res}meforest/img/logo.png" alt="Home">
                                                </a>
                                            </div><!-- /.logo -->

                                            <div class="site-name">
                                                <a href="/" title="Home" class="brand">Realia</a>
                                            </div><!-- /.site-name -->

                                            <div class="site-slogan">
                                                <span>Real estate &amp; Rental<br>made easy</span>
                                            </div><!-- /.site-slogan -->
                                        </div><!-- /.logo-wrapper -->

                                        <div class="info">
                                            <div class="site-email">
                                                <a href="mailto:info@byaviators.com">info@byaviators.com</a>
                                            </div><!-- /.site-email -->

                                            <div class="site-phone">
                                                <span>333-666-777</span>
                                            </div><!-- /.site-phone -->
                                        </div><!-- /.info -->
                                    </div><!-- /.row -->
                                </div><!-- /.navbar-inner -->
                            </div><!-- /.navbar -->
                        </div><!-- /.container -->
                    </div><!-- /#header-inner -->
                </div><!-- /#header -->
            </div><!-- /#header-wrapper -->

            <!-- NAVIGATION -->
            <div id="navigation">
                <div class="container">
                    <div class="navigation-wrapper">
                        <div class="navigation clearfix-normal">

                            <ul class="nav">
                                <li><a href="contact-us.html">Главная</a></li>
                                <li><a href="contact-us.html">Список</a></li>
                                <li><a href="contact-us.html">Как это работает</a></li>
                                <li><a href="contact-us.html">Стать партнером</a></li>
                                <li><a href="contact-us.html">Контакты</a></li>
                            </ul><!-- /.nav -->
                        </div><!-- /.navigation -->
                    </div><!-- /.navigation-wrapper -->
                </div><!-- /.container -->
            </div><!-- /.navigation -->

            <!-- CONTENT -->
            <div id="content"><div class="container">
                <div id="main">
                    <div class="row">
                        <div class="span9">
                            <h1 class="page-header">${billboard.address}</h1>

                            <div class="carousel property">
                                <div class="preview">
                                    <img src="${res}meforest/img/tmp/property-large-1.jpg" alt="">
                                </div><!-- /.preview -->

                                <div class="content">

                                    <a class="carousel-prev" href="#">Previous</a>
                                    <a class="carousel-next" href="#">Next</a>
                                    <ul>
                                        <li class="active">
                                            <img src="${res}meforest/img/tmp/property-large-1.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-2.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-3.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-4.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-1.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-2.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-3.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-4.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-1.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-2.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-3.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-4.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-1.jpg" alt="">
                                        </li>
                                        <li>
                                            <img src="${res}meforest/img/tmp/property-large-2.jpg" alt="">
                                        </li>
                                    </ul>
                                </div>
                                <!-- /.content -->
                            </div>
                            <!-- /.carousel -->

                            <div class="property-detail">
                                <%
                                    for(TimetableSideDto side : (List<TimetableSideDto>)request.getAttribute("sides")) {
                                        for(int surfaceId=0; surfaceId<side.getBbSide().getSurfaceCount(); surfaceId++) { %>
                                            <div class="box-header with-border">
                                                <h3 class="box-title">Баннер: <%=side.getBbSide().getName()+ surfaceId %></h3>
                                            </div>
                                                <table id="example1" class="table table-bordered table-striped">
                                                    <tbody>
                                                        <tr>
                                                            <% for(Month m : (List<Month>)request.getAttribute("months")) { %>
                                                                <td><%=String.format("%s %d", I18nUtils.month(m.getNum()), m.getYear()) %></td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <% for(Month m : (List<Month>)request.getAttribute("months")) { %>
                                                            <td>
                                                                <%=side.get(surfaceId, m.getYear(), m.getNum()).getRent() %> руб.
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <% for(Month m : (List<Month>)request.getAttribute("months")) { %>
                                                            <td>
                                                                <%
                                                                Timetable t = side.get(surfaceId, m.getYear(), m.getNum());
                                                                String rowId = ("" + side.getBbSide().getId()) + "_" + ("" + surfaceId) + "_" + ("" + m.getYear()) + "_" + ("" + m.getNum());
                                                                %>
                                                            <form id="form_<%=rowId%>"action="${root}contract" method="post" hidden>
                                                                <input type="hidden" name="sideId" value="<%=side.getBbSide().getId()%>"/>
                                                                <input type="hidden" name="surfaceId" value="<%=surfaceId%>"/>
                                                                <input type="hidden" name="year" value="<%=m.getYear()%>"/>
                                                                <input type="hidden" name="month" value="<%=m.getNum()%>"/>
                                                                <input type="hidden" name="phone" id="phone_<%=rowId%>"/>
                                                                <input type="hidden" name="comment" id="comment_<%=rowId%>"/>
                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                            </form>
                                                            <button <%=t.getStatus()==Timetable.Status.OPEN ? "" : "disabled style='background-color: red'"%> onclick="show_dialog('<%=rowId%>')" class="btn btn-primary"><%=t.getStatus()==Timetable.Status.OPEN ? "Бронировать" : "Занято"%></button>
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                <% }} %>
                                <h2>Карта</h2>
                                <div id="map"></div><!-- /#property-map -->
                            </div>

                        </div>
                        <div class="sidebar span3">
                            <div class="widget our-agents">
                                <div class="title">
                                    <h2>Стоимость</h2>
                                </div><!-- /.title -->

                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/rub_icon.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="name">${minRent} руб.</div><!-- /.name -->
                                        <div class="email">* стоимость одной поверхности</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                            </div><!-- /.our-agents -->
                            <div class="widget our-agents">
                                <div class="title">
                                    <h2>Параметры</h2>
                                </div><!-- /.title -->

                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/width.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="name">${minRent} руб.</div><!-- /.name -->
                                        <div class="email">* стоимость одной поверхности</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/height.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="name">${minRent} руб.</div><!-- /.name -->
                                        <div class="email">* стоимость одной поверхности</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/light.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="name">${minRent} руб.</div><!-- /.name -->
                                        <div class="email">* стоимость одной поверхности</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/format.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="name">${minRent} руб.</div><!-- /.name -->
                                        <div class="email">* стоимость одной поверхности</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                            </div><!-- /.our-agents -->
                        </div>
                    </div>
                </div>
            </div>
            </div><!-- /#content -->
        </div><!-- /#wrapper-inner -->

        <div id="footer-wrapper">
            <div id="footer-top">
                <div id="footer-top-inner" class="container">
                    <div class="row">
                        <div class="widget properties span3">
                            <div class="title">
                                <h2>Most Recent</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->

                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->

                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-3.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->
                            </div><!-- /.content -->
                        </div><!-- /.properties-small -->

                        <div class="widget span3">
                            <div class="title">
                                <h2>Contact us</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <table class="contact">
                                    <tbody>
                                    <tr>
                                        <th class="address">Address:</th>
                                        <td>1900 Pico Blvd<br>Santa Monica, CA 90405<br>United States<br></td>
                                    </tr>
                                    <tr>
                                        <th class="phone">Phone:</th>
                                        <td>+48 123 456 789</td>
                                    </tr>
                                    <tr>
                                        <th class="email">E-mail:</th>
                                        <td><a href="mailto:info@yourcompany.com">info@example.com</a></td>
                                    </tr>
                                    <tr>
                                        <th class="skype">Skype:</th>
                                        <td>your.company</td>
                                    </tr>
                                    <tr>
                                        <th class="gps">GPS:</th>
                                        <td>34.016811<br>-118.469009</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->

                        <div class="widget span3">
                            <div class="title">
                                <h2 class="block-title">Useful links</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <ul class="menu nav">
                                    <li class="first leaf"><a href="404.html">404 page</a></li>
                                    <li class="leaf"><a href="about-us.html">About us</a></li>
                                    <li class="leaf"><a href="contact-us.html">Contact us</a></li>
                                    <li class="leaf"><a href="faq.html">FAQ</a></li>
                                    <li class="leaf"><a href="grid-system.html">Grid system</a></li>
                                    <li class="leaf"><a href="our-agents.html">Our agents</a></li>
                                    <li class="last leaf"><a href="typography.html">Typography</a></li>
                                </ul>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->

                        <div class="widget span3">
                            <div class="title">
                                <h2 class="block-title">Say hello!</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <form method="post">
                                    <div class="control-group">
                                        <label class="control-label" for="inputName">
                                            Name
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>
                                        <div class="controls">
                                            <input type="text" id="inputName">
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="control-group">
                                        <label class="control-label" for="inputEmail">
                                            Email
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>
                                        <div class="controls">
                                            <input type="text" id="inputEmail">
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="control-group">
                                        <label class="control-label" for="inputMessage">
                                            Message
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>

                                        <div class="controls">
                                            <textarea id="inputMessage"></textarea>
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="form-actions">
                                        <input type="submit" class="btn btn-primary arrow-right" value="Send">
                                    </div><!-- /.form-actions -->
                                </form>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->
                    </div><!-- /.row -->
                </div><!-- /#footer-top-inner -->
            </div><!-- /#footer-top -->

            <div id="footer" class="footer container">
                <div id="footer-inner">
                    <div class="row">
                        <div class="span6 copyright">
                            <p>© Copyright 2013 by <a href="http://themes.byaviators.com">Aviators</a>. All rights reserved.</p>
                        </div><!-- /.copyright -->

                        <div class="span6 share">
                            <div class="content">
                                <ul class="menu nav">
                                    <li class="first leaf"><a href="http://www.facebook.com" class="facebook">Facebook</a></li>
                                    <li class="leaf"><a href="http://flickr.net" class="flickr">Flickr</a></li>
                                    <li class="leaf"><a href="http://plus.google.com" class="google">Google+</a></li>
                                    <li class="leaf"><a href="http://www.linkedin.com" class="linkedin">LinkedIn</a></li>
                                    <li class="leaf"><a href="http://www.twitter.com" class="twitter">Twitter</a></li>
                                    <li class="last leaf"><a href="http://www.vimeo.com" class="vimeo">Vimeo</a></li>
                                </ul>
                            </div><!-- /.content -->
                        </div><!-- /.span6 -->
                    </div><!-- /.row -->
                </div><!-- /#footer-inner -->
            </div><!-- /#footer -->
        </div><!-- /#footer-wrapper -->
    </div><!-- /#wrapper -->
</div><!-- /#wrapper-outer -->

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&amp;sensor=true&amp;key=AIzaSyAgk4LbwN0qnW-MzWT8rD1DGgStymdb1nQ"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.ezmark.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.currency.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${res}meforest/js/retina.js"></script>
<script type="text/javascript" src="${res}meforest/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/carousel.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.infobox.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${res}meforest/js/realia.js"></script>
<script type="text/javascript" src="${res}/bootstrap/js/bootstrap-dialog.min.js"></script>
</body>
</html>
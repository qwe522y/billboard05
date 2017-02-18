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
    <link href="${res}/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
    <title>Realia | HTML Template</title>
    <script type="text/javascript">
window.myrespath = "${res}";
window.absoluteMinRent = ${absoluteMinRent};
window.absoluteMaxRent = ${absoluteMaxRent};
window.inputPriceFrom_val = "${absoluteMinRent}";
window.inputPriceTo_val = "${absoluteMaxRent}";

window.billboards = [
<c:forEach items="${billboards}" var="i">
    {"id": ${i.e.id}, "position": [${i.e.location}], "address": "${i.e.address}", "price": "${minRentMap[i.e.id]}",
        "type": "${i.type.name}", "format": "${i.format.name}", "city": "${i.city.name}",
        "width": ${i.e.width}, "height": ${i.e.height}},
</c:forEach>
];
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
                                    <li><a href="agent/">Вход</a></li>
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
                                <li><a href="${root}">Главная</a></li>
                                <li><a href="${root}">Список</a></li>
                                <li><a href="${root}">Как это работает</a></li>
                                <li><a href="${root}">Стать партнером</a></li>
                                <li><a href="${root}">Контакты</a></li>
                            </ul><!-- /.nav -->
                        </div><!-- /.navigation -->
                    </div><!-- /.navigation-wrapper -->
                </div><!-- /.container -->
            </div><!-- /.navigation -->

            <!-- CONTENT -->
            <div id="content">
                <div class="map-wrapper">
                    <div class="map">
                        <div id="map" class="map-inner"></div><!-- /.map-inner -->

                        <div class="container">
                            <div class="row">
                                <div class="span3">
                                    <div class="property-filter pull-right">
                                        <div class="content">
                                            <form method="get" action="?">
                                                <div class="location control-group">
                                                    <label class="control-label" for="inputLocation">
                                                        Место
                                                    </label>
                                                    <div class="controls">
                                                        <select id="inputLocation">
                                                            <c:forEach items="${cities}" var="city">
                                                                <option value="${city.location}">${city.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div><!-- /.controls -->
                                                </div><!-- /.control-group -->

                                                <div class="type control-group">
                                                    <label class="control-label" for="inputType">
                                                        Тип
                                                    </label>
                                                    <div class="controls">
                                                        <select id="inputType">
                                                            <option value="0">Все</option>
                                                            <c:forEach items="${billboardTypes}" var="type">
                                                                <option value="${type.id}">${type.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div><!-- /.controls -->
                                                </div><!-- /.control-group -->

                                                <div class="type control-group">
                                                    <label class="control-label" for="inputFormat">
                                                        Формат
                                                    </label>
                                                    <div class="controls">
                                                        <select id="inputFormat">
                                                            <option value="0">Все</option>
                                                            <c:forEach items="${billboardFormats}" var="format">
                                                                <option value="${format.id}">${format.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div><!-- /.controls -->
                                                </div><!-- /.control-group -->

                                                <div class="price-from control-group">
                                                    <label class="control-label" for="inputPriceFrom">
                                                        Price from
                                                    </label>
                                                    <div class="controls">
                                                        <input type="text" id="inputPriceFrom" name="inputPriceFrom">
                                                    </div><!-- /.controls -->
                                                </div><!-- /.control-group -->

                                                <div class="price-to control-group">
                                                    <label class="control-label" for="inputPriceTo">
                                                        Price to
                                                    </label>
                                                    <div class="controls">
                                                        <input type="text" id="inputPriceTo" name="inputPriceTo">
                                                    </div><!-- /.controls -->
                                                </div><!-- /.control-group -->

                                                <div class="price-value">
                                                    <span class="from"></span><!-- /.from -->
                                                    -
                                                    <span class="to"></span><!-- /.to -->
                                                </div><!-- /.price-value -->

                                                <div class="price-slider">
                                                </div><!-- /.price-slider -->

                                                <div class="form-actions">
                                                    <input type="button" value="Поиск" class="btn btn-primary btn-large">
                                                </div><!-- /.form-actions -->
                                            </form>
                                        </div><!-- /.content -->
                                    </div><!-- /.property-filter -->
                                </div><!-- /.span3 -->
                            </div><!-- /.row -->
                        </div><!-- /.container -->
                    </div><!-- /.map -->
                </div><!-- /.map-wrapper -->
                <div class="container">
                    <div id="main">
                        <div class="row">
                            <div class="span9">
                                <h1 class="page-header">Горячее предложение</h1>
                                <div class="properties-grid">
                                    <div class="row">
                                        <% for(int i=0; i<6; i++) { %>
                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html" id="details_<%=i%>"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-1.png" alt="" id="photo_<%=i%>">
                                                </div><!-- /.content -->

                                                <div class="price" id="price_<%=i%>"></div><!-- /.price -->
                                                <div class="reduced" id="type_<%=i%>"></div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html" id="name_<%=i%>"></a></h2>
                                            </div><!-- /.title -->

                                            <div class="location" id="city_<%=i%>"></div><!-- /.location -->
                                            <div class="bedrooms"><div class="content" style="background-image: url(${res}png/width.png)" id="width_<%=i%>"></div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content" style="background-image: url(${res}png/height.png)" id="height_<%=i%>"></div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->
                                        <% } %>
                                    </div><!-- /.row -->
                                </div><!-- /.properties-grid -->
                            </div>
                            <div class="sidebar span3">
                                <div class="hidden-tablet">
                                    <div class="widget properties last">
                                        <div class="title">
                                            <h2>Последние</h2>
                                        </div><!-- /.title -->

                                        <div class="content">
                                            <% for(int i=0; i<4; i++) { %>
                                            <div class="property">
                                                <div class="image">
                                                    <a href="" id="side_details_<%=i%>"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-4.png" alt="" id="side_photo_<%=i%>">
                                                </div><!-- /.image -->

                                                <div class="wrapper">
                                                    <div class="title">
                                                        <h3>
                                                            <a href="detail.html" id="side_name_<%=i%>"></a>
                                                        </h3>
                                                    </div><!-- /.title -->
                                                    <div class="location" id="side_city_<%=i%>"></div><!-- /.location -->
                                                    <div class="price" id="side_price_<%=i%>"></div><!-- /.price -->
                                                </div><!-- /.wrapper -->
                                            </div><!-- /.property -->
                                            <% } %>
                                        </div><!-- /.content -->
                                    </div><!-- /.properties -->
                                </div>
                            </div>
                        </div>
                        <div class="features">
                        </div>
                    </div><!-- /.features -->    </div>
                </div>

                <div class="bottom-wrapper">
                    <div class="bottom container">
                        <div class="bottom-inner row">
                            <div class="item span4">
                                <div class="address decoration"></div>
                                <h2><a>Интерактивная карта</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="gps decoration"></div>
                                <h2><a>Актуальные данные</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="key decoration"></div>
                                <h2><a>Полное оформление</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                            </div><!-- /.item -->
                        </div><!-- /.bottom-inner -->
                    </div><!-- /.bottom -->
                </div><!-- /.bottom-wrapper -->
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
                                        <div class="location"></div><!-- /.location -->
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
<script type="text/javascript" src="${res}js/home.js"></script>
<script type="text/javascript" src="${res}meforest/js/realia.js"></script>
<script type="text/javascript" src="${res}/bootstrap/js/bootstrap-dialog.min.js"></script>

<script type="text/javascript">
    $(function () {
        // сообщения
        var title = "Информация";
        var type =  BootstrapDialog.SUCCESS;
        var msg = "${msg.msg}";
        <% session.removeAttribute("msg"); %>
        if(msg.length > 0) {
            BootstrapDialog.alert({
                title: title,
                message: msg,
                type: type, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
                buttonLabel: 'Ok'
            });
        }
    });
</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Служба рекламы</title>
</head>
<body>
<div id="wrapper-outer" >
    <div id="wrapper">
        <div id="wrapper-inner">
            <jsp:include page="header.jsp"/>
            <!-- CONTENT -->
            <div id="content">    <div class="container">
                <div id="main">
                    <div class="row">
                        <div class="span9">
                            <h1 class="page-header">Contact us</h1>
                            <iframe class="map" width="425" height="350" src="https://maps.google.com/maps?q=37.440587,-122.139816&amp;num=1&amp;ie=UTF8&amp;ll=37.435681,-122.135696&amp;spn=0.041038,0.077162&amp;t=m&amp;z=14&amp;output=embed"></iframe>

                            <p>
                                Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.
                            </p>

                            <div class="row">
                                <div class="span3">
                                    <h3 class="address">Address</h3>
                                    <p class="content-icon-spacing">
                                        13/2 Elizabeth Street<br>
                                        Melbourne, Australia
                                    </p>
                                </div>
                                <div class="span3">
                                    <h3 class="call-us">Call us</h3>
                                    <p class="content-icon-spacing">
                                        1900-CO-WORKER<br>
                                        1800-3322-4453
                                    </p>
                                </div>
                                <div class="span3">
                                    <h3 class="email">Email</h3>
                                    <p class="content-icon-spacing">
                                        <a href="mailto:info@byaviators.com">contact management</a><br>
                                        <a href="mailto:support@byaviators.com">contact support</a>
                                    </p>
                                </div>
                            </div>

                            <h2>We'd love to hear from you. Say us hello!</h2>

                            <form method="post" class="contact-form" action="?">
                                <div class="name control-group">
                                    <label class="control-label" for="inputContactName">
                                        Name
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="inputContactName">
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="email control-group">
                                    <label class="control-label" for="inputContactEmail">
                                        Email
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="inputContactEmail">
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="control-group">
                                    <label class="control-label" for="inputContactMessage">
                                        Message
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>

                                    <div class="controls">
                                        <textarea id="inputContactMessage"></textarea>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="form-actions">
                                    <input type="submit" class="btn btn-primary arrow-right" value="Send">
                                </div><!-- /.form-actions -->
                            </form>
                        </div>

                        <div class="sidebar span3">
                            <div class="widget properties last">
                                <div class="title">
                                    <h2>Latest Properties</h2>
                                </div><!-- /.title -->

                                <div class="content">
                                    <div class="property">
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="assets/img/tmp/property-small-4.png" alt="">
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
                                            <img src="assets/img/tmp/property-small-5.png" alt="">
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
                                            <img src="assets/img/tmp/property-small-6.png" alt="">
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
                                            <img src="assets/img/tmp/property-small-2.png" alt="">
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
                            </div><!-- /.properties -->
                            <div class="ad widget">
                                <h2>Advertisements</h2>
                                <div class="content">
                                    <a href="#"><img src="assets/img/banner/1.gif" alt="Banner"></a>
                                    <a href="#"><img src="assets/img/banner/2.gif" alt="Banner"></a>
                                    <a href="#"><img src="assets/img/banner/3.gif" alt="Banner"></a>
                                    <a href="#"><img src="assets/img/banner/4.gif" alt="Banner"></a>
                                </div><!-- /.content -->
                            </div><!-- /.ad -->
                        </div>
                    </div>
                </div>
            </div>
            </div><!-- /#content -->
        </div><!-- /#wrapper-inner -->
        <jsp:include page="footer.jsp"/>
    </div><!-- /#wrapper -->
</div><!-- /#wrapper-outer -->

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&amp;sensor=true&amp;key=AIzaSyAgk4LbwN0qnW-MzWT8rD1DGgStymdb1nQ"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.ezmark.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.currency.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${res}meforest/js/retina.js"></script>
<script type="text/javascript" src="${res}meforest/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${res}meforest/js/realia.js"></script>
<script type="text/javascript" src="${res}/bootstrap/js/bootstrap-dialog.min.js"></script>
</body>
</html>
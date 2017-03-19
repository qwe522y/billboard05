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
                            <h1 class="page-header">Стать партнером</h1>

                            <sf:form method="post" class="contact-form">

                                <div class="name control-group">
                                    <label class="control-label" for="name">
                                        Название агенства
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="name" name="name" required>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="email control-group">
                                    <label class="control-label" for="phone">
                                        Телефон
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="phone" name="phone" required>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="name control-group">
                                    <label class="control-label" for="email">
                                        Email
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="email" name="email" required>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="email control-group">
                                    <label class="control-label" for="region">
                                        Регион развития
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>
                                    <div class="controls">
                                        <input type="text" id="region" name="region" required>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="control-group">
                                    <label class="control-label" for="inputContactMessage">
                                        Сообщение
                                        <span class="form-required" title="This field is required.">*</span>
                                    </label>

                                    <div class="controls">
                                        <textarea id="inputContactMessage" name="msg"></textarea>
                                    </div><!-- /.controls -->
                                </div><!-- /.control-group -->

                                <div class="form-actions">
                                    <input type="submit" class="btn btn-primary arrow-right" value="Отправить">
                                </div><!-- /.form-actions -->
                            </sf:form>
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
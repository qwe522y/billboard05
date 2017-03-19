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
            <div id="content"><div class="container">
                <div id="main">
                    <h1 class="page-header">Как это работает</h1>
                    <p>Как это работает?
                        Сервис “Служба Рекламы” облегчает рекламодателю поиск необходимого ему рекламного щита. Рекламодатель может сразу на нашем сайте узнать стоимость аренды и расписание рекламного щита. При желании, на сайте же он может заброниовать понравившийся ему щит.
                        </p>
                    <hr>
                    <h2>Для владельцев рекламных щитов</h2>
                    <p>“Служба Рекламы” предлагает сервис для удобного управления и контроля рекламными щитами и взаимодействия со своими клиентами. Также, посредством него можно привлечь дополнительных клиентов.</p>
                    <hr>
                    <h2>Рекламодателю</h2>
                    <p>Аренда рекламного щита. Рекламодатель может использовать несколько способов для поиска нужной рекламной поверхности:
                        <ul>
                            <li>Поиск по карте</li>
                            <li>Фильтр по параметрам</li>
                        </ul>
                    На сайте сразу можно узнать когда свободен нужный билборд и цену, а также забронировать его.
                    </p>
                    <hr>
                    <h2>Решение для владельцев рекламных щитов</h2>
                    <p>Владельцам рекламных щитов мы предлагаем два варианта работы с нашим сервисом:
                        <ul>
                            <li>Мы открываем владельцам/рекламному агентству личный кабинет на нашем сервисе, где они смогут сами обновлять информацию о щитах, обрабатывать заявки от рекламодателей, видеть актуальную информацию по доходам, загруженность щитов.
                                Рекламодатели будут напрямую связываться с владельцами/рекламным агентством при аренде щита.</li>
                            <li>
                                Владельцы рекламных щитов предоставляют информацию о щитах менеджерам сервиса. Обновлением и приемом заявок также будут заниматься менеджеры сервиса.
                            </li>
                        </ul>
                    </p>
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
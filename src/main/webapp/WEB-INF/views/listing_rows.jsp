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
    <title>Служба рекламы</title>
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
            <jsp:include page="header.jsp"/>
            <!-- CONTENT -->
            <div id="content">
                <div class="container">

                    <div id="main">
                        <div class="row">
                            <div class="span9">
                                <h1 class="page-header">Отфильтрованный список</h1>

                                <div class="properties-rows">
                                    <div class="filter">
                                        <form action="?" method="get" class="form-horizontal">
                                            <div class="control-group">
                                                <label class="control-label" for="inputSortBy">
                                                    Поле
                                                    <span class="form-required" title="This field is required.">*</span>
                                                </label>
                                                <div class="controls">
                                                    <select id="inputSortBy">
                                                        <option id="price">Цена</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="control-group">
                                                <label class="control-label" for="inputOrder">
                                                    Порядок
                                                    <span class="form-required" title="This field is required.">*</span>
                                                </label>
                                                <div class="controls">
                                                    <select id="inputOrder">
                                                        <option value="asc">Возрастание</option>
                                                        <option value="desc">Убывание</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->
                                        </form>
                                    </div><!-- /.filter -->
                                </div><!-- /.properties-rows -->                <div class="properties-rows">
                                <div class="row">
                                    <%for(int i=0; i<5; i++) { %>
                                    <div class="property span9" id="bb_row_<%=i %>">
                                        <div class="row">
                                            <div class="image span3">
                                                <div class="content">
                                                    <a href="detail.html" id="detail_<%=i %>"></a>
                                                    <img id="photo_<%=i %>"src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                                </div><!-- /.content -->
                                            </div><!-- /.image -->

                                            <div class="body span6">
                                                <div class="title-price row">
                                                    <div class="title span4">
                                                        <h2><a href="detail.html" id="name_<%=i %>">27523 Pacific Coast</a></h2>
                                                    </div><!-- /.title -->

                                                    <div class="price" id="price_<%=i %>">
                                                        1 250 000€
                                                    </div><!-- /.price -->
                                                </div><!-- /.title -->

                                                <div class="location" id="city_<%=i %>">Palo Alto CA</div><!-- /.location -->
                                                <p>Etiam at ante id enim dictum posuere id vel est. Praesent at massa quis risus cursus tristique vel non orci. Phasellus ut nisi non odio</p>
                                                <div class="bedrooms"><div class="content" style="background-image: url(${res}png/width.png)" id="width_<%=i%>"></div></div><!-- /.bedrooms -->
                                                <div class="bathrooms"><div class="content" style="background-image: url(${res}png/height.png)" id="height_<%=i%>"></div></div><!-- /.bathrooms -->
                                            </div><!-- /.body -->
                                        </div><!-- /.property -->
                                    </div><!-- /.row -->
                                    <% } %>
                                </div><!-- /.row -->
                            </div><!-- /.properties-rows -->
                                <%--
                                <div class="pagination pagination-centered">
                                    <ul>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li class="active"><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">next</a></li>
                                        <li><a href="#">last</a></li>
                                    </ul>
                                </div><!-- /.pagination -->
                                --%>
                                </div>
                            <div class="sidebar span3">
                                <h2>Фильтр</h2>
                                <div class="property-filter widget">
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
                                                    <input type="text" id="inputPriceFrom" name="inputPriceFrom" value="${absoluteMinRent}">
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="price-to control-group">
                                                <label class="control-label" for="inputPriceTo">
                                                    Price to
                                                </label>
                                                <div class="controls">
                                                    <input type="text" id="inputPriceTo" name="inputPriceTo" value="${absoluteMaxRent}">
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
                                <div class="ad widget">
                                    <h2>Advertisements</h2>
                                    <div class="content">
                                        <a href="#"><img src="${res}meforest/img/banner/1.gif" alt="Banner"></a>
                                        <a href="#"><img src="${res}meforest/img/banner/2.gif" alt="Banner"></a>
                                        <a href="#"><img src="${res}meforest/img/banner/3.gif" alt="Banner"></a>
                                        <a href="#"><img src="${res}meforest/img/banner/4.gif" alt="Banner"></a>
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

<script type="text/javascript" src="${res}meforest/js/jquery.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.ezmark.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.currency.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${res}meforest/js/retina.js"></script>
<script type="text/javascript" src="${res}meforest/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/carousel.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${res}meforest/js/realia.js"></script>
<script type="text/javascript" src="${res}js/listing_rows.js"></script>
</body>
</html>
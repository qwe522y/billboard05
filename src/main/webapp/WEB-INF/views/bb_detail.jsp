<%@ page import="com.sotas.billboard05.dto.Month" %>
<%@ page import="com.sotas.billboard05.dto.TimetableSideDto" %>
<%@ page import="com.sotas.billboard05.entity.Timetable" %>
<%@ page import="com.sotas.billboard05.utils.I18nUtils" %>
<%@ page import="java.util.List" %>
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
    <title>Подробности</title>
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
            <jsp:include page="header.jsp"/>
            <!-- CONTENT -->
            <div id="content"><div class="container">
                <div id="main">
                    <div class="row">
                        <div class="span9">
                            <h1 class="page-header">${billboard.address}</h1>

                            <div class="carousel property">
                                <div class="preview">
                                    <img src="${res}photo/${billboard.id}/0.jpg" alt="">
                                </div><!-- /.preview -->

                                <div class="content">

                                    <a class="carousel-prev" href="#">Previous</a>
                                    <a class="carousel-next" href="#">Next</a>
                                    <ul>
                                        <c:forEach begin="0" end="${imgCount-1}" var="i">
                                            <li <c:if test="${i==0}"> class="active" </c:if> >
                                                <img src="${res}photo/${billboard.id}/${i}.jpg" alt="">
                                            </li>
                                        </c:forEach>
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
                                                                <%=side.get(surfaceId, m.getYear(), m.getNum()).getRent().intValue() %> руб.
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
                                                            <form id="form_<%=rowId%>" action="${root}contract" method="post" hidden>
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
                                            <img src="${res}png/rub_icon.png" alt="" width="64px" height="64px">
                                        </div><!-- /.image -->
                                        <div class="name"><fmt:formatNumber value="${minRent}" minFractionDigits="0" groupingUsed="true"/> руб.</div><!-- /.name -->
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
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                        <div class="name">Ширина: ${billboard.width} м</div><!-- /.name -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/height.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                        <div class="name">Высота: ${billboard.height} м</div><!-- /.name -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/light.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                        <div class="name">Освещение: ${light}</div><!-- /.name -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                                <div class="content">
                                    <div class="agent">
                                        <div class="image">
                                            <img src="${res}png/format.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                        <div class="name">Формат: ${bbFormat}</div><!-- /.name -->
                                        <div class="email">&nbsp;</div><!-- /.email -->
                                    </div><!-- /.agent -->
                                </div><!-- /.content -->
                            </div><!-- /.our-agents -->
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
<!--<script type="text/javascript" src="${res}meforest/js/retina.js"></script>-->
<script type="text/javascript" src="${res}meforest/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/carousel.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.infobox.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${res}/js/bb_detail.js"></script>
<script type="text/javascript" src="${res}/bootstrap/js/bootstrap-dialog.min.js"></script>
</body>
</html>
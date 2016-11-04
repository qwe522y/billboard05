<%@ page import="com.sotas.billboard05.dto.TimetableSideDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sotas.billboard05.dto.Month" %>
<%@ page import="com.sotas.billboard05.entity.Timetable" %>
<%@ page import="com.sotas.billboard05.utils.I18nUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../parts/init.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/parts/head.jsp"/>
    <title>${projectTitle} личный кабинет</title>
    <script>
        function timetable_update(rowId) {
            status = $("#status_field_" + rowId).val();
            rent = $("#rent_field_" + rowId).val();
            $("#status" + rowId).val(status);
            $("#rent" + rowId).val(rent);
            $("#form_" + rowId).submit();
        }
    </script>
    <style>
        td .form-group {
            margin-bottom: 0px;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<jsp:include page="/WEB-INF/views/parts/panels.jsp"/>
<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->

        <section class="content-header">
            <h1>
                Выставление цен в разрезе даты
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Рекламные точки</a></li>
                <li class="active">Цены</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <%
                for(TimetableSideDto side : (List<TimetableSideDto>)request.getAttribute("sides")) {
                    for(int surfaceId=0; surfaceId<side.getBbSide().getSurfaceCount(); surfaceId++) { %>
            <div class="row">
                <div class="col-md-6">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">Поверхность: <%=side.getBbSide().getName()+ surfaceId %></h3>
                        </div>
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <tbody>
                                <%
                                    for(Month m : (List<Month>)request.getAttribute("months")) {
                                        Timetable t = side.get(surfaceId, m.getYear(), m.getNum());
                                %>
                                    <tr>
                                        <% String rowId = ("" + side.getBbSide().getId()) + "_" + ("" + surfaceId) + "_" + ("" + m.getYear()) + "_" + ("" + m.getNum()); %>
                                        <td><%=String.format("%02d-%d", m.getNum()+1, m.getYear()) %></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input type="number" class="form-control" value="<%=t.getRent() %>" id="rent_field_<%=rowId%>">
                                                    <div class="input-group-addon">Руб.</div>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-9">
                                                <select class="form-control select2", id="status_field_<%=rowId%>">
                                                    <option value="<%=Timetable.Status.OPEN %>" <%=t.getStatus() == Timetable.Status.OPEN ? "selected" : ""%>><%=I18nUtils.timetableStatus(Timetable.Status.OPEN) %></option>
                                                    <option value="<%=Timetable.Status.CLOSE %>" <%=t.getStatus() == Timetable.Status.CLOSE ? "selected" : ""%>><%=I18nUtils.timetableStatus(Timetable.Status.CLOSE) %></option>
                                                </select>
                                            </div>
                                        </td>
                                        <td>
                                            <form id="form_<%=rowId%>"action="." method="post">
                                                <input type="hidden" name="sideId" value="<%=side.getBbSide().getId()%>"/>
                                                <input type="hidden" name="surfaceId" value="<%=surfaceId%>"/>
                                                <input type="hidden" name="year" value="<%=m.getYear()%>"/>
                                                <input type="hidden" name="month" value="<%=m.getNum()%>"/>
                                                <input type="hidden" name="status" id="status<%=rowId%>"/>
                                                <input type="hidden" name="rent" id="rent<%=rowId%>"/>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            </form>
                                            <button onclick="timetable_update('<%=rowId%>')" class="btn btn-primary">Сохранить</button>
                                        </td>
                                    </tr>
                                <% } %>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <% }} %>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.6
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<jsp:include page="/WEB-INF/views/parts/post_body.jsp"/>
</body>
</html>

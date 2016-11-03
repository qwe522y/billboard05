<%@ page import="com.sotas.billboard05.dto.TimetableSideDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sotas.billboard05.dto.Month" %>
<%@ page import="com.sotas.billboard05.entity.Timetable" %>
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
            <% for(TimetableSideDto side : (List<TimetableSideDto>)request.getAttribute("sides")) { %>
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <a href="add">Добавить</a>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <tbody>
                                <%
                                    for(Month m : (List<Month>)request.getAttribute("months")) {
                                        for(int surfaceId=0; surfaceId<side.getBbSide().getSurfaceCount(); surfaceId++) {
                                            Timetable t = side.get(surfaceId).get(m.getYear()).get(m.getNum());
                                %>
                                    <tr>
                                        <td><%=m %></td>
                                        <td><%=t.getRent() %> руб.</td>
                                        <td><%=t.getStatus() %></td>
                                    </tr>
                                <% }} %>
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
            <% } %>
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

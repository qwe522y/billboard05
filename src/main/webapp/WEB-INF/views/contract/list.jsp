<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                Заявки
                <small>Список заявок на рекламу</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>Номер точки</th>
                                    <th>Адрес</th>
                                    <th>Поверхность</th>
                                    <th>Телефон</th>
                                    <th>Доп. информация</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${contracts}" var="i">
                                    <tr>
                                        <td>${i.billboard.id}</td>
                                        <td>${i.billboard.address}</td>
                                        <td>${i.billboardSide.name}${i.timetable.surface}</td>
                                        <td>${i.e.clientPhone}</td>
                                        <td>${i.e.clientComment}</td>
                                    </tr>
                                </c:forEach>
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

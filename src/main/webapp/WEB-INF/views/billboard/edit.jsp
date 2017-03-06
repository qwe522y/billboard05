<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../parts/init.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${projectTitle} личный кабинет</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="${res}bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="${res}plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="${res}plugins/datepicker/datepicker3.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="${res}plugins/iCheck/all.css">
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="${res}plugins/colorpicker/bootstrap-colorpicker.min.css">
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="${res}plugins/timepicker/bootstrap-timepicker.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${res}plugins/select2/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${res}dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${res}dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&amp;sensor=true&amp;key=AIzaSyAgk4LbwN0qnW-MzWT8rD1DGgStymdb1nQ"></script>
    <script>
        var cities = {
            <c:forEach items="${cities}" var="city">
                "${city.id}" : "${city.location}",
            </c:forEach>
        };

        // cмена центра карты при смене города
        function changeLocation() {
            center = cities[$("#cityField").val()].split(",");
            var pos = new google.maps.LatLng(center[0], center[1]);
            window.map.setCenter(pos);
            moveMark(pos)
            $("#locationField").val(center);
        }
    </script>
    <style>
        #map {
            width: 100%; height: 510px; padding: 0; margin: 0;
        }
    </style>
</head>
<body class="skin-blue">
<jsp:include page="/WEB-INF/views/parts/panels.jsp"/>
<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->

        <section class="content-header">
            <h1>
                Добавление новой рекламной точки
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Forms</a></li>
                <li class="active">General Elements</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <!-- left column -->

                <!--/.col (left) -->
                <!-- right column -->
                <div class="col-lg-6">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Заполните форму</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <sf:form method="post" modelAttribute="billboard" class="form-horizontal" action="edit">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="cityField">Город</label>
                                    <div class="col-sm-9">
                                        <sf:select path="cityId" class="form-control select2" style="width: 100%;" id="cityField">
                                            <c:forEach items="${cities}" var="city">
                                                <sf:option value="${city.id}">${city.name}</sf:option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="addressField">Адрес</label>
                                    <div class="col-sm-9">
                                        <sf:input path="address" id="addressField" type="text" placeholder="Адрес" class="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="billboardTypeField">Тип</label>
                                    <div class="col-sm-9">
                                        <sf:select path="typeId" class="form-control select2" style="width: 100%;" id="billboardTypeField">
                                            <c:forEach items="${billboardTypes}" var="type">
                                                <sf:option value="${type.id}">${type.name}</sf:option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="billboardFormatField">Тип</label>
                                    <div class="col-sm-9">
                                        <sf:select path="formatId" class="form-control select2" style="width: 100%;" id="billboardFormatField">
                                            <c:forEach items="${billboardFormats}" var="format">
                                                <sf:option value="${format.id}">${format.name}</sf:option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9">
                                        <div class="light">
                                            <label>
                                                <spring:bind path="light">
                                                    <sf:checkbox path="light"/>
                                                </spring:bind>
                                                Освещение
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ownerField">Владелец</label>
                                    <div class="col-sm-9">
                                        <sf:select path="ownerId" class="form-control select2" style="width: 100%;" id="ownerField">
                                            <c:forEach items="${owners}" var="owner">
                                                <sf:option  value="${owner.id}">${owner.name} ${owner.phone}</sf:option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="widthField">Ширина</label>
                                    <div class="col-sm-9">
                                        <sf:input path="width" id="widthField" type="number" placeholder="введите ширину поверхности" class="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="heightField">Высота</label>
                                    <div class="col-sm-9">
                                        <sf:input path="height" id="heightField" type="number" placeholder="введите высоту поверхности" class="form-control" required="required"/>
                                    </div>
                                </div>
                                <sf:hidden path="location" id="locationField"/>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button class="btn btn-info pull-right" type="submit">Сохранить</button>
                            </div>
                            <!-- /.box-footer -->
                        </sf:form>
                    </div>
                    <!-- /.box -->
                    <!-- general form elements disabled -->

                    <!-- /.box -->
                </div>
                <!--/.col (right) -->
                <div class="col-lg-6">
                    <div id="map"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Изображения</h3>
                        </div>
                        <sf:form method="post" class="form-horizontal" action="updateMiniPhoto" enctype="multipart/form-data">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Мини изображение(PNG)</label>
                                <div class="col-sm-1">
                                    <img width="54" height="40" src="${root}res/photo/${billboard.id}/0.png"/>
                                </div>
                                <div class="col-sm-6">
                                    <input name="miniPhoto" id="miniPhoto" type="file" class="form-control" required/>
                                </div>
                                <div class="col-sm-2">
                                    <button class="btn btn-info pull-right" type="submit">Заменить</button>
                                </div>
                            </div>
                        </sf:form>
                        <c:forEach begin="0" end="${imgCount-1}" var="i">
                            <sf:form method="post" class="form-horizontal" action="updatePhoto" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">фотография #${i}(JPG)</label>
                                    <div class="col-sm-2">
                                        <img width="87" height="42" src="${root}res/photo/${billboard.id}/${i}.jpg"/>
                                    </div>
                                    <div class="col-sm-3">
                                        <input name="photo" id="photo_${i}" type="file" class="form-control"/>
                                    </div>
                                    <div class="col-sm-2">
                                        <button class="btn btn-danger pull-right" type="submit" name="action" value="delete">Удалить</button>
                                    </div>
                                    <div class="col-sm-2">
                                        <button class="btn btn-info pull-right" type="submit" name="action" value="update">Заменить</button>
                                    </div>
                                    <input type="hidden" name="index" value="${i}"/>
                                </div>
                            </sf:form>
                        </c:forEach>
                        <sf:form method="post" class="form-horizontal" action="addPhoto" enctype="multipart/form-data">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Новая фотография(JPG)</label>
                                <div class="col-sm-5">
                                    <input name="photo" id="photo_${imgCount}" type="file" class="form-control" required/>
                                </div>
                                <div class="col-sm-2">
                                    <button class="btn btn-info pull-right" type="submit">Добавить</button>
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
            </div> <!-- /row -->
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

<!-- jQuery 2.2.3 -->
<script src="${res}plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${res}bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="${res}plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="${res}plugins/input-mask/jquery.inputmask.js"></script>
<script src="${res}plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${res}plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${res}plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${res}plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${res}plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="${res}plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${res}plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${res}plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="${res}plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${res}dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${res}dist/js/demo.js"></script>
<!-- Page script -->
<script>
    $(function () {
        //Initialize Select2 Elements
        $(".select2").select2();

        //Datemask dd/mm/yyyy
        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
        //Datemask2 mm/dd/yyyy
        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
        //Money Euro
        $("[data-mask]").inputmask();

        //Date range picker
        $('#reservation').daterangepicker();
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
        //Date range as a button
        $('#daterange-btn').daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
        );

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true
        });

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass: 'iradio_minimal-red'
        });
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });

        //Colorpicker
        $(".my-colorpicker1").colorpicker();
        //color picker with addon
        $(".my-colorpicker2").colorpicker();

        //Timepicker
        $(".timepicker").timepicker({
            showInputs: false
        });
    });

    $(function () {
        window.map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 14
        });
        $("#cityField").change(changeLocation);
        google.maps.event.addListener(map, 'click', function(event) {
            moveMark(event.latLng)
        });
        window.mark = new google.maps.Marker({
            position: new google.maps.LatLng(0, 0),
            map: window.map,
            icon: '${res}/meforest/img/marker.png',
            draggable:true
        });
        mark.addListener("dragend", function (event) {
            moveMarkAffect(this.getPosition())
        });

        center = $("#locationField").val().split(",");
        var pos = new google.maps.LatLng(center[0], center[1]);
        window.map.setCenter(pos);
        window.mark.setPosition(pos);
    });
    function moveMark(pos) {
        console.log("moveMark pos=" + pos)
        window.mark.setPosition(pos);
        moveMarkAffect(pos)
    }
    function moveMarkAffect(pos) {
        var p = pos.lat() + "," + pos.lng();
        $("#locationField").val(p);
        console.log("change center to " + p);
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-92632891-1', 'auto');
    ga('send', 'pageview');

</script>
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
                        <li><a href="${root}agent/">Вход</a></li>
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
                                    <a href="${root}" title="Home">
                                        <img src="${res}meforest/img/logo.png" alt="Home">
                                    </a>
                                </div><!-- /.logo -->

                                <div class="site-name">
                                    <a href="${root}" class="brand">Служба рекламы</a>
                                </div><!-- /.site-name -->
                            </div><!-- /.logo-wrapper -->

                            <div class="info">
                                <div class="site-email">
                                    <a href="mailto:info@byaviators.com">murad1986@gmail.com</a>
                                </div><!-- /.site-email -->

                                <div class="site-phone">
                                    <span>+7(928)576-78-45</span>
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
                    <li><a href="${root}list">Список</a></li>
                    <li><a href="${root}">Как это работает</a></li>
                    <li><a href="${root}">Стать партнером</a></li>
                    <li><a href="${root}">Контакты</a></li>
                </ul><!-- /.nav -->
            </div><!-- /.navigation -->
        </div><!-- /.navigation-wrapper -->
    </div><!-- /.container -->
</div><!-- /.navigation -->
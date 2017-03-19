<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- google analitics BEGIN-->
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-92632891-1', 'auto');
    ga('send', 'pageview');
</script>
<!-- google analitics END-->

<!-- Facebook Pixel Code -->
<script>
    !function(f,b,e,v,n,t,s){if(f.fbq)return;n=f.fbq=function(){n.callMethod?
            n.callMethod.apply(n,arguments):n.queue.push(arguments)};if(!f._fbq)f._fbq=n;
        n.push=n;n.loaded=!0;n.version='2.0';n.queue=[];t=b.createElement(e);t.async=!0;
        t.src=v;s=b.getElementsByTagName(e)[0];s.parentNode.insertBefore(t,s)}(window,
            document,'script','https://connect.facebook.net/en_US/fbevents.js');
    fbq('init', '240942506370924'); // Insert your pixel ID here.
    fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=240942506370924&ev=PageView&noscript=1"/></noscript>
<!-- End Facebook Pixel Code -->

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
                                    <a href="mailto:contact@findboard.ru">contact@findboard.com</a>
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
                    <li><a href="${root}how_it_works">Как это работает</a></li>
                    <li><a href="${root}become_partner" onclick="fbq('track', 'Lead')">Стать партнером</a></li>
                    <li><a href="${root}">Контакты</a></li>
                </ul><!-- /.nav -->
            </div><!-- /.navigation -->
        </div><!-- /.navigation-wrapper -->
    </div><!-- /.container -->
</div><!-- /.navigation -->
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
    <link rel="stylesheet" href="#" type="text/css" id="color-variant">

    <title>Realia | HTML Template</title>
</head>
<body>
<div id="wrapper-outer" >
    <div id="wrapper">
        <div id="wrapper-inner">
            <!-- BREADCRUMB -->
            <div class="breadcrumb-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <ul class="breadcrumb pull-left">
                                <li><a href="index.html">Home</a></li>
                            </ul><!-- /.breadcrumb -->

                            <div class="account pull-right">
                                <ul class="nav nav-pills">
                                    <li><a href="login.html">Login</a></li>
                                    <li><a href="registration.html">Registration</a></li>
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
                                                <a href="index.html" title="Home">
                                                    <img src="${res}meforest/img/logo.png" alt="Home">
                                                </a>
                                            </div><!-- /.logo -->

                                            <div class="site-name">
                                                <a href="/" title="Home" class="brand">Realia</a>
                                            </div><!-- /.site-name -->

                                            <div class="site-slogan">
                                                <span>Real estate &amp; Rental<br>made easy</span>
                                            </div><!-- /.site-slogan -->
                                        </div><!-- /.logo-wrapper -->

                                        <div class="info">
                                            <div class="site-email">
                                                <a href="mailto:info@byaviators.com">info@byaviators.com</a>
                                            </div><!-- /.site-email -->

                                            <div class="site-phone">
                                                <span>333-666-777</span>
                                            </div><!-- /.site-phone -->
                                        </div><!-- /.info -->

                                        <a class="btn btn-primary btn-large list-your-property arrow-right" href="list-your-property.html">List your property</a>
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
                                <li class="menuparent">
                                    <span class="menuparent nolink">Homepage</span>
                                    <ul>
                                        <li><a href="index-slider.html">Homepage with slider</a></li>
                                        <li><a href="index.html">Homepage with map</a></li>
                                        <li><a href="index-simple.html">Simple homepage</a></li>
                                        <li><a href="index-carousel.html">Homepage with carousel</a></li>
                                    </ul>
                                </li>
                                <li class="menuparent">
                                    <span class="menuparent nolink">Listing</span>
                                    <ul>
                                        <li><a href="listing-grid.html">Listing grid</a></li>
                                        <li><a href="listing-grid-filter.html">Listing grid with filter</a></li>
                                        <li><a href="listing-rows.html">Listing rows</a></li>
                                        <li><a href="listing-rows-filter.html" >Listing rows with filter</a></li>
                                    </ul>
                                </li>
                                <li class="menuparent">
                                    <span class="menuparent nolink">Pages</span>
                                    <ul>
                                        <li><a href="about-us.html">About us</a></li>
                                        <li><a href="our-agents.html">Our agents</a></li>
                                        <li><a href="faq.html">FAQ</a></li>
                                        <li><a href="shortcodes.html">Shortcodes</a></li>
                                        <li class="menuparent">
                                            <span class="menuparent nolink">Another level</span>
                                            <ul>
                                                <li><a href="contact-us.html">Contact us</a></li>
                                                <li><a href="grid-system.html">Grid system</a></li>
                                                <li><a href="typography.html">Typography</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="404.html">404 page</a></li>
                                    </ul>
                                </li>
                                <li class="menuparent">
                                    <span class="menuparent nolink">Pricing</span>
                                    <ul>
                                        <li><a href="pricing-boxed.html">Boxed pricing</a></li>
                                        <li><a href="pricing-multiple.html">Multiple pricing</a></li>
                                        <li><a href="pricing-simple.html">Simple Pricing</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact-us.html">Contact Us</a></li>
                            </ul><!-- /.nav -->

                            <div class="language-switcher">
                                <div class="current en"><a href="/" lang="en">English</a></div><!-- /.current -->
                                <div class="options">
                                    <ul>
                                        <li class="fr"><a href="#">Français</a></li>
                                        <li class="de"><a href="#">Deutsch</a></li>
                                    </ul>
                                </div><!-- /.options -->
                            </div><!-- /.language-switcher -->

                            <form method="get" class="site-search" action="?">
                                <div class="input-append">
                                    <input title="Enter the terms you wish to search for." class="search-query span2 form-text" placeholder="Search" type="text" name="">
                                    <button type="submit" class="btn"><i class="icon-search"></i></button>
                                </div><!-- /.input-append -->
                            </form><!-- /.site-search -->
                        </div><!-- /.navigation -->
                    </div><!-- /.navigation-wrapper -->
                </div><!-- /.container -->
            </div><!-- /.navigation -->

            <!-- CONTENT -->
            <div id="content"><div class="map-wrapper">
                <div class="map">
                    <div id="map" class="map-inner"></div><!-- /.map-inner -->

                    <div class="container">
                        <div class="row">
                            <div class="span3">
                                <div class="property-filter pull-right">
                                    <div class="content">
                                        <form method="get" action="?">
                                            <div class="location control-group">
                                                <label class="control-label" for="inputLocation">
                                                    Location
                                                </label>
                                                <div class="controls">
                                                    <select id="inputLocation">
                                                        <option id="malibu">Malibu, CA</option>
                                                        <option id="palo-alto">Palo Alto, CA</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="type control-group">
                                                <label class="control-label" for="inputType">
                                                    Type
                                                </label>
                                                <div class="controls">
                                                    <select id="inputType">
                                                        <option id="apartment">Apartment</option>
                                                        <option id="condo">Condo</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="beds control-group">
                                                <label class="control-label" for="inputBeds">
                                                    Beds
                                                </label>
                                                <div class="controls">
                                                    <select id="inputBeds">
                                                        <option id="11">1</option>
                                                        <option id="21">2</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="baths control-group">
                                                <label class="control-label" for="inputBaths">
                                                    Baths
                                                </label>
                                                <div class="controls">
                                                    <select id="inputBaths">
                                                        <option id="1">1</option>
                                                        <option id="2">2</option>
                                                    </select>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->


                                            <div class="rent control-group">
                                                <div class="controls">
                                                    <label class="checkbox" for="inputRent">
                                                        <input type="checkbox" id="inputRent"> Rent
                                                    </label>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="sale control-group">
                                                <div class="controls">
                                                    <label class="checkbox" for="inputSale">
                                                        <input type="checkbox" id="inputSale"> Sale
                                                    </label>
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="price-from control-group">
                                                <label class="control-label" for="inputPriceFrom">
                                                    Price from
                                                </label>
                                                <div class="controls">
                                                    <input type="text" id="inputPriceFrom" name="inputPriceFrom">
                                                </div><!-- /.controls -->
                                            </div><!-- /.control-group -->

                                            <div class="price-to control-group">
                                                <label class="control-label" for="inputPriceTo">
                                                    Price to
                                                </label>
                                                <div class="controls">
                                                    <input type="text" id="inputPriceTo" name="inputPriceTo">
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
                                                <input type="submit" value="Filter now!" class="btn btn-primary btn-large">
                                            </div><!-- /.form-actions -->
                                        </form>
                                    </div><!-- /.content -->
                                </div><!-- /.property-filter -->
                            </div><!-- /.span3 -->
                        </div><!-- /.row -->
                    </div><!-- /.container -->
                </div><!-- /.map -->
            </div><!-- /.map-wrapper -->
                <div class="container">
                    <div id="main">
                        <div class="row">
                            <div class="span9">
                                <h1 class="page-header">Featured properties</h1>
                                <div class="properties-grid">
                                    <div class="row">
                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                                </div><!-- /.content -->

                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->

                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                                </div><!-- /.content -->
                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->

                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-3.png" alt="">
                                                </div><!-- /.content -->

                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->

                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-4.png" alt="">
                                                </div><!-- /.content -->
                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->

                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-5.png" alt="">
                                                </div><!-- /.content -->

                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->

                                        <div class="property span3">
                                            <div class="image">
                                                <div class="content">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-6.png" alt="">
                                                </div><!-- /.content -->

                                                <div class="price">1 250 000€</div><!-- /.price -->
                                                <div class="reduced">Reduced </div><!-- /.reduced -->
                                            </div><!-- /.image -->

                                            <div class="title">
                                                <h2><a href="detail.html">27523 Pacific Coast</a></h2>
                                            </div><!-- /.title -->

                                            <div class="location">Palo Alto CA</div><!-- /.location -->
                                            <div class="area">
                                                <span class="key">Area:</span><!-- /.key -->
                                                <span class="value">120</span><!-- /.value -->
                                            </div><!-- /.area -->
                                            <div class="bedrooms"><div class="content">4</div></div><!-- /.bedrooms -->
                                            <div class="bathrooms"><div class="content">3</div></div><!-- /.bathrooms -->
                                        </div><!-- /.property -->
                                    </div><!-- /.row -->
                                </div><!-- /.properties-grid -->
                            </div>
                            <div class="sidebar span3">
                                <div class="widget our-agents">
                                    <div class="title">
                                        <h2>Our Agents</h2>
                                    </div><!-- /.title -->

                                    <div class="content">
                                        <div class="agent">
                                            <div class="image">
                                                <img src="${res}meforest/img/photos/emma-small.png" alt="">
                                            </div><!-- /.image -->
                                            <div class="name">Victoria Summer</div><!-- /.name -->
                                            <div class="phone">333-666-777</div><!-- /.phone -->
                                            <div class="email"><a href="mailto:victoria@example.com">victoria@example.com</a></div><!-- /.email -->
                                        </div><!-- /.agent -->

                                        <div class="agent">
                                            <div class="image">
                                                <img src="${res}meforest/img/photos/john-small.png" alt="">
                                            </div><!-- /.image -->
                                            <div class="name">John Doe</div><!-- /.name -->
                                            <div class="phone">111-222-333</div><!-- /.phone -->
                                            <div class="email"><a href="mailto:john.doe@example.com">victoria@example.com</a></div><!-- /.email -->
                                        </div><!-- /.agent -->
                                    </div><!-- /.content -->
                                </div><!-- /.our-agents -->
                                <div class="hidden-tablet">
                                    <div class="widget properties last">
                                        <div class="title">
                                            <h2>Latest Properties</h2>
                                        </div><!-- /.title -->

                                        <div class="content">
                                            <div class="property">
                                                <div class="image">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-4.png" alt="">
                                                </div><!-- /.image -->

                                                <div class="wrapper">
                                                    <div class="title">
                                                        <h3>
                                                            <a href="detail.html">27523 Pacific Coast</a>
                                                        </h3>
                                                    </div><!-- /.title -->
                                                    <div class="location">Palo Alto CA</div><!-- /.location -->
                                                    <div class="price">€2 300 000</div><!-- /.price -->
                                                </div><!-- /.wrapper -->
                                            </div><!-- /.property -->

                                            <div class="property">
                                                <div class="image">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-5.png" alt="">
                                                </div><!-- /.image -->

                                                <div class="wrapper">
                                                    <div class="title">
                                                        <h3>
                                                            <a href="detail.html">27523 Pacific Coast</a>
                                                        </h3>
                                                    </div><!-- /.title -->
                                                    <div class="location">Palo Alto CA</div><!-- /.location -->
                                                    <div class="price">€2 300 000</div><!-- /.price -->
                                                </div><!-- /.wrapper -->
                                            </div><!-- /.property -->

                                            <div class="property">
                                                <div class="image">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-6.png" alt="">
                                                </div><!-- /.image -->

                                                <div class="wrapper">
                                                    <div class="title">
                                                        <h3>
                                                            <a href="detail.html">27523 Pacific Coast</a>
                                                        </h3>
                                                    </div><!-- /.title -->
                                                    <div class="location">Palo Alto CA</div><!-- /.location -->
                                                    <div class="price">€2 300 000</div><!-- /.price -->
                                                </div><!-- /.wrapper -->
                                            </div><!-- /.property -->

                                            <div class="property">
                                                <div class="image">
                                                    <a href="detail.html"></a>
                                                    <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                                </div><!-- /.image -->

                                                <div class="wrapper">
                                                    <div class="title">
                                                        <h3>
                                                            <a href="detail.html">27523 Pacific Coast</a>
                                                        </h3>
                                                    </div><!-- /.title -->
                                                    <div class="location">Palo Alto CA</div><!-- /.location -->
                                                    <div class="price">€2 300 000</div><!-- /.price -->
                                                </div><!-- /.wrapper -->
                                            </div><!-- /.property -->
                                        </div><!-- /.content -->
                                    </div><!-- /.properties -->
                                </div>
                            </div>
                        </div>
                        <div class="carousel">
                            <h2 class="page-header">All properties</h2>

                            <div class="content">
                                <a class="carousel-prev" href="detail.html">Previous</a>
                                <a class="carousel-next" href="detail.html">Next</a>
                                <ul>
                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>
                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-3.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-4.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-5.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-6.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-3.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>

                                    <li>
                                        <div class="image">
                                            <a href="detail.html"></a>
                                            <img src="${res}meforest/img/tmp/property-small-4.png" alt="">
                                        </div><!-- /.image -->
                                        <div class="title">
                                            <h3><a href="detail.html">27523 Pacific Coast</a></h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location-->
                                        <div class="price">€2 300 000</div><!-- .price -->
                                        <div class="area">
                                            <span class="key">Area:</span>
                                            <span class="value">750m<sup>2</sup></span>
                                        </div><!-- /.area -->
                                        <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                                        <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
                                    </li>
                                </ul>
                            </div><!-- /.content -->
                        </div><!-- /.carousel -->        <div class="features">
                        <h2 class="page-header">Theme features</h2>

                        <div class="row">
                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-seo.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>SEO Ready</h3>
                                        <p>Realia is ready to put your website on higher ranks. Every line of code was developed with SEO principles in mind.</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-retina.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>Retina Ready</h3>
                                        <p>Realia looks great even on Retina and high-resoultion displays. Every graphic element is sharp and clean. No blurry images anymore!</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-custom-widgets.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>Custom Widgets</h3>
                                        <p>Realia provides custom developed widgets to fulfil requirements of good real estate application.</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->
                        </div>
                        <div class="row">
                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-bootstrap.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>Prepared for Bootstrap</h3>
                                        <p>Developer friendly code based on Bootstrap and SASS makes your own customizations really easy.</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-pencil.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>Frontend Submission</h3>
                                        <p>Make the portal solution from your real estate by providing property submission on homepage.</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="row">
                                    <div class="icon span1">
                                        <img src="${res}meforest/img/icons/features-responsive.png" alt="">
                                    </div><!-- /.icon -->

                                    <div class="text span3">
                                        <h3>Responsive</h3>
                                        <p>Realia is ready to put your website on higher ranks. Every line of code was developed with SEO principles in mind.</p>
                                    </div><!-- /.logo -->
                                </div><!-- /.row -->
                            </div><!-- /.item -->
                        </div><!-- /.row -->
                    </div><!-- /.features -->    </div>
                </div>

                <div class="bottom-wrapper">
                    <div class="bottom container">
                        <div class="bottom-inner row">
                            <div class="item span4">
                                <div class="address decoration"></div>
                                <h2><a>List your property</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                                <a href="#" class="btn btn-primary">Read more</a>
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="gps decoration"></div>
                                <h2><a>Advertise rentals</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                                <a href="#" class="btn btn-primary">Read more</a>
                            </div><!-- /.item -->

                            <div class="item span4">
                                <div class="key decoration"></div>
                                <h2><a>Guidance</a></h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla accumsan dui ac nunc imperdiet rhoncus. Aenean vitae imperdiet lectus</p>
                                <a href="#" class="btn btn-primary">Read more</a>
                            </div><!-- /.item -->
                        </div><!-- /.bottom-inner -->
                    </div><!-- /.bottom -->
                </div><!-- /.bottom-wrapper -->    </div><!-- /#content -->
        </div><!-- /#wrapper-inner -->

        <div id="footer-wrapper">
            <div id="footer-top">
                <div id="footer-top-inner" class="container">
                    <div class="row">
                        <div class="widget properties span3">
                            <div class="title">
                                <h2>Most Recent</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-1.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->

                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-2.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->

                                <div class="property">
                                    <div class="image">
                                        <a href="detail.html"></a>
                                        <img src="${res}meforest/img/tmp/property-small-3.png" alt="">
                                    </div><!-- /.image -->
                                    <div class="wrapper">
                                        <div class="title">
                                            <h3>
                                                <a href="detail.html">27523 Pacific Coast</a>
                                            </h3>
                                        </div><!-- /.title -->
                                        <div class="location">Palo Alto CA</div><!-- /.location -->
                                        <div class="price">€2 300 000</div><!-- /.price -->
                                    </div><!-- /.wrapper -->
                                </div><!-- /.property -->
                            </div><!-- /.content -->
                        </div><!-- /.properties-small -->

                        <div class="widget span3">
                            <div class="title">
                                <h2>Contact us</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <table class="contact">
                                    <tbody>
                                    <tr>
                                        <th class="address">Address:</th>
                                        <td>1900 Pico Blvd<br>Santa Monica, CA 90405<br>United States<br></td>
                                    </tr>
                                    <tr>
                                        <th class="phone">Phone:</th>
                                        <td>+48 123 456 789</td>
                                    </tr>
                                    <tr>
                                        <th class="email">E-mail:</th>
                                        <td><a href="mailto:info@yourcompany.com">info@example.com</a></td>
                                    </tr>
                                    <tr>
                                        <th class="skype">Skype:</th>
                                        <td>your.company</td>
                                    </tr>
                                    <tr>
                                        <th class="gps">GPS:</th>
                                        <td>34.016811<br>-118.469009</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->

                        <div class="widget span3">
                            <div class="title">
                                <h2 class="block-title">Useful links</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <ul class="menu nav">
                                    <li class="first leaf"><a href="404.html">404 page</a></li>
                                    <li class="leaf"><a href="about-us.html">About us</a></li>
                                    <li class="leaf"><a href="contact-us.html">Contact us</a></li>
                                    <li class="leaf"><a href="faq.html">FAQ</a></li>
                                    <li class="leaf"><a href="grid-system.html">Grid system</a></li>
                                    <li class="leaf"><a href="our-agents.html">Our agents</a></li>
                                    <li class="last leaf"><a href="typography.html">Typography</a></li>
                                </ul>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->

                        <div class="widget span3">
                            <div class="title">
                                <h2 class="block-title">Say hello!</h2>
                            </div><!-- /.title -->

                            <div class="content">
                                <form method="post">
                                    <div class="control-group">
                                        <label class="control-label" for="inputName">
                                            Name
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>
                                        <div class="controls">
                                            <input type="text" id="inputName">
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="control-group">
                                        <label class="control-label" for="inputEmail">
                                            Email
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>
                                        <div class="controls">
                                            <input type="text" id="inputEmail">
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="control-group">
                                        <label class="control-label" for="inputMessage">
                                            Message
                                            <span class="form-required" title="This field is required.">*</span>
                                        </label>

                                        <div class="controls">
                                            <textarea id="inputMessage"></textarea>
                                        </div><!-- /.controls -->
                                    </div><!-- /.control-group -->

                                    <div class="form-actions">
                                        <input type="submit" class="btn btn-primary arrow-right" value="Send">
                                    </div><!-- /.form-actions -->
                                </form>
                            </div><!-- /.content -->
                        </div><!-- /.widget -->
                    </div><!-- /.row -->
                </div><!-- /#footer-top-inner -->
            </div><!-- /#footer-top -->

            <div id="footer" class="footer container">
                <div id="footer-inner">
                    <div class="row">
                        <div class="span6 copyright">
                            <p>© Copyright 2013 by <a href="http://themes.byaviators.com">Aviators</a>. All rights reserved.</p>
                        </div><!-- /.copyright -->

                        <div class="span6 share">
                            <div class="content">
                                <ul class="menu nav">
                                    <li class="first leaf"><a href="http://www.facebook.com" class="facebook">Facebook</a></li>
                                    <li class="leaf"><a href="http://flickr.net" class="flickr">Flickr</a></li>
                                    <li class="leaf"><a href="http://plus.google.com" class="google">Google+</a></li>
                                    <li class="leaf"><a href="http://www.linkedin.com" class="linkedin">LinkedIn</a></li>
                                    <li class="leaf"><a href="http://www.twitter.com" class="twitter">Twitter</a></li>
                                    <li class="last leaf"><a href="http://www.vimeo.com" class="vimeo">Vimeo</a></li>
                                </ul>
                            </div><!-- /.content -->
                        </div><!-- /.span6 -->
                    </div><!-- /.row -->
                </div><!-- /#footer-inner -->
            </div><!-- /#footer -->
        </div><!-- /#footer-wrapper -->
    </div><!-- /#wrapper -->
</div><!-- /#wrapper-outer -->

<div class="palette">
    <div class="toggle">
        <a href="#">Toggle</a>
    </div><!-- /.toggle -->

    <div class="inner">
        <div class="headers">
            <h2>Header styles</h2>
            <ul>
                <li><a class="header-light">Light</a></li>
                <li><a class="header-normal">Normal</a></li>
                <li><a class="header-dark">Dark</a></li>
            </ul>
        </div><!-- /.headers -->

        <div class="patterns">
            <h2>Background patterns</h2>
            <ul>
                <li><a class="pattern-cloth-alike">cloth-alike</a></li>
                <li><a class="pattern-corrugation">corrugation</a></li>
                <li><a class="pattern-diagonal-noise">diagonal-noise</a></li>
                <li><a class="pattern-dust">dust</a></li>
                <li><a class="pattern-fabric-plaid">fabric-plaid</a></li>
                <li><a class="pattern-farmer">farmer</a></li>
                <li><a class="pattern-grid-noise">grid-noise</a></li>
                <li><a class="pattern-lghtmesh">lghtmesh</a></li>
                <li><a class="pattern-pw-maze-white">pw-maze-white</a></li>
                <li><a class="pattern-none">none</a></li>
            </ul>
        </div>

        <div class="colors">
            <h2>Color variants</h2>
            <ul>
                <li><a href="${res}meforest/css/realia-red.css" class="red">Red</a></li>
                <li><a href="${res}meforest/css/realia-magenta.css" class="magenta">Magenta</a></li>
                <li><a href="${res}meforest/css/realia-brown.css" class="brown">Brown</a></li>
                <li><a href="${res}meforest/css/realia-orange.css" class="orange">Orange</a></li>
                <li><a href="${res}meforest/css/realia-brown-dark.css" class="brown-dark">Brown dark</a></li>

                <li><a href="${res}meforest/css/realia-gray-red.css" class="gray-red">Gray Red</a></li>
                <li><a href="${res}meforest/css/realia-gray-magenta.css" class="gray-magenta">Gray Magenta</a></li>
                <li><a href="${res}meforest/css/realia-gray-brown.css" class="gray-brown">Gray Brown</a></li>
                <li><a href="${res}meforest/css/realia-gray-orange.css" class="gray-orange">Gray Orange</a></li>
                <li><a href="${res}meforest/css/realia-gray-brown-dark.css" class="gray-brown-dark">Gray Brown dark</a></li>

                <li><a href="${res}meforest/css/realia-green-light.css" class="green-light">Green light</a></li>
                <li><a href="${res}meforest/css/realia-green.css" class="green">Green</a></li>
                <li><a href="${res}meforest/css/realia-turquiose.css" class="turquiose">Turquiose</a></li>
                <li><a href="${res}meforest/css/realia-blue.css" class="blue">Blue</a></li>
                <li><a href="${res}meforest/css/realia-violet.css" class="violet">Violet</a></li>

                <li><a href="${res}meforest/css/realia-gray-green-light.css" class="gray-green-light">Gray Green light</a></li>
                <li><a href="${res}meforest/css/realia-gray-green.css" class="gray-green">Gray Green</a></li>
                <li><a href="${res}meforest/css/realia-gray-turquiose.css" class="gray-turquiose">Gray Turquiose</a></li>
                <li><a href="${res}meforest/css/realia-gray-blue.css" class="gray-blue">Gray Blue</a></li>
                <li><a href="${res}meforest/css/realia-gray-violet.css" class="gray-violet">Gray Violet</a></li>
            </ul>
        </div><!-- /.colors -->

        <a href="#" class="btn btn-primary reset">Reset default</a>
    </div><!-- /.inner -->
</div><!-- /.palette -->

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&amp;sensor=true"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.ezmark.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.currency.js"></script>
<script type="text/javascript" src="${res}meforest/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${res}meforest/js/retina.js"></script>
<script type="text/javascript" src="${res}meforest/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/carousel.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.min.js"></script>
<script type="text/javascript" src="${res}meforest/js/gmap3.infobox.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="${res}meforest/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${res}meforest/js/realia.js"></script>
</body>
</html>
<%--
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
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="${res}plugins/timepicker/bootstrap-timepicker.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${res}plugins/select2/select2.min.css">
    <!-- bootstrap dialog -->
    <link href="${res}/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script>
        var billboards = {
            "type": "FeatureCollection",
            "features": [
                <c:forEach items="${billboards}" var="i">
                    {"type": "Feature", "id": ${i.e.id}, "geometry": {"type": "Point", "coordinates": [${i.e.location}]}, "properties": {"bb_address": "${i.e.address}", "hintContent": "${i.e.address}"}},
                </c:forEach>
            ]
        };
        ymaps.ready(init);
        var myMap;
        function init () {
            myMap = new ymaps.Map("map", {
                        center: [42.975182, 47.503995],
                        zoom: 14
                    }, {
                        searchControlProvider: 'yandex#search'
                    });

            objectManager = new ymaps.ObjectManager({
                // Чтобы метки начали кластеризоваться, выставляем опцию.
                clusterize: true,
                // ObjectManager принимает те же опции, что и кластеризатор.
                gridSize: 32
            });

            myMap.geoObjects.add(objectManager);
            objectManager.add(billboards);
            objectManager.events.add("click", function (e) {
                var id = e.get("objectId");
                var bb =  objectManager.objects.getById(id)
                if(bb.properties.balloonContent == undefined) {
                    bb.properties.balloonContent = [
                        '<address>',
                        '<strong>Цена: неизвестно</strong>',
                        '<br/>',
                        bb.properties.bb_address,
                        '<br/>',
                        '<a href="${root}bb/' + id + '">Подробнее</a>',
                        '</address>'
                    ].join('');
                }
                objectManager.objects.balloon.open(id);
            });
        }
    </script>
    <style>
        #map {
            width: 100%; height: 500px; padding: 0; margin: 0;
        }
    </style>
</head>
<body>
<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">${projectTitle}</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="agent/">Вход</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <div class="container">
        <div class="row" >
            <div class="form-group form-inline">
                <select class="form-control select2" id="citySelectField">
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.location}">${city.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="jumbotron" style="padding: 5px; margin-bottom: 0px;">
        <div id="map"></div>
    </div>
</div> <!-- /container -->

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
<!-- bootstrap dialog -->
<script src="${res}/bootstrap/js/bootstrap-dialog.min.js"></script>
<!-- Page script -->
<script>
    $(function () {
        //Initialize Select2 Elements
        $(".select2").select2({
                minimumResultsForSearch: 10
        });

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
        /* мой костыль для управлением высотой карты */
        var h = $(window).height();
        if(h > 500) {
            $("#map").height(h-150);
        }

        // cмена центра карты при смене города
        $( "#citySelectField" ).change(function() {
            center = $("#citySelectField").val().split(",");
            myMap.setCenter(center);
        });

        // сообщения
        $(function() {
            var title = "Информация"
            var type =  BootstrapDialog.SUCCESS;
            var msg = "${msg.msg}"
            <% session.removeAttribute("msg"); %>
            if(msg.length > 0) {
                BootstrapDialog.alert({
                    title: title,
                    message: msg,
                    type: type, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
                    buttonLabel: 'Ok'
                });
            }
        });
    });
</script>
</body>
</html>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url var="res" value="/res/" scope="application"/>
<spring:url var="root" value="/" scope="application"/>
<spring:url var="home" value="/" scope="application"/>
<spring:url var="loginUrl" value="/j_spring_security_check" scope="application"/>
<spring:url var="logoutUrl" value="/j_spring_security_logout" scope="application"/>

<c:set var="projectTitle" value="MarketBil" scope="application"/>
<c:set var="projectTitleShort" value="MBil" scope="application"/>


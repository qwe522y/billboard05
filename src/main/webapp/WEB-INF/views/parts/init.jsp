<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url var="res" value="/res/" scope="request"/>
<spring:url var="loginUrl" value="/j_spring_security_check" scope="request"/>
<spring:url var="logoutUrl" value="/j_spring_security_logout" scope="request"/>


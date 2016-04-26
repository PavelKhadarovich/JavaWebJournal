<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Weclome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<h3>Welcome to Web Journal!</h3>

<nav>
    <ul>
        <li><a href="<c:url value='/showlogin' />">Login</a></li>
        <li><a href="<c:url value='/user-create' />">Register</a></li>
        <li><a href="<c:url value='/reviewslist' />">Show Review List</a></li>

    </ul>
</nav>
</body>
</html>

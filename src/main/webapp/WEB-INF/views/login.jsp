<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="well lead">Login</div>
    <form method="post" action="login">
        <div>
            <label for="ssoId">Login</label>
            <div>
                <input type="text" id="ssoId" placeholder="Login" name="ssoId">
            </div>
        </div>
        <div>
            <label for="password">Password</label>
            <div>
                <input type="password" id="password" placeholder="Password" name="password">
            </div>
        </div>
        <div>
            <div>
                <label class="checkbox">
                    <input type="checkbox"> Remember me
                </label>
                <button type="submit">Login</button>
                <p><font color="red">${error}</font></p>
            </div>
        </div>
    </form>
</div>
</div>
</body>
</html>
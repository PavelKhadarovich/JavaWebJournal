<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div>
	<div>
		${success}
	</div>

	<nav>
		<ul>
			<li><a href="<c:url value='/list' />">Show User List</a></li>
			<li><a href="<c:url value='/reviewslist' />">Show Review List</a></li>
			<li><a href="<c:url value='/placeslist' />">Show Place List</a></li>
			<li><a href="<c:url value='/taskslist' />">Show Task List</a></li>
			<li><a href="<c:url value='/logout' />">Logout</a></li>
		</ul>
	</nav>

</div>
</body>

</html>
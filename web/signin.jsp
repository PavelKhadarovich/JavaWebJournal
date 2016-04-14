
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>HireThem</title>
</head>
<body>
<h1>Sign In to HireThem</h1>
<s:form name="signInForm" action="signin" method="POST">
    <s:textfield name="email" label="Email "/>
    <s:password label="Password " name="password"/>
    <s:textfield name="name" label="Name "/>
    <s:textfield name="surname" label="Surname "/>
    <s:radio label="Register as " key="userType" list="userTypes"/>
    <s:submit type="button" label="Sign In"/>
</s:form>
</body>
</html>

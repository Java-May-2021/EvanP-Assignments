<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
<div class="container">
	<h1>Register!</h1>
	<p><form:errors path="user.*"/></p>

    <form:form method="POST" action="/" modelAttribute="user">
        <div class="form-group">
            <form:label path="firstName">First Name: </form:label>
            <form:errors path="firstName"/>
            <form:input class="form-control" path="firstName"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name: </form:label>
            <form:errors path="lastName"/>
            <form:input class="form-control" path="lastName"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email: </form:label>
            <form:errors path="email"/>
            <form:input class="form-control" path="email"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password: </form:label>
            <form:errors path="password"/>
            <form:password class="form-control" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:errors path="passwordConfirmation"/>
            <form:password class="form-control" path="passwordConfirmation"/>
        </div>
        <button class="btn btn-warning">Register!</button>
    </form:form>
</div>
<div class="container">    
    <h1>Login</h1>
    <p><c:out value="${error}"/></p>
    <form:form method="post" action="/login" modelAttribute="user">
    	<div class="form-group">
            <form:label path="email">Email</form:label>
            <form:errors path="email"/>
            <form:input class="form-group" path="email"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password</form:label>
            <form:errors path="password"/>
            <form:input class="form-group" path="password"/>
     </div>
        <button class="btn btn-warning">Login!</button>
    </form:form>  
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add a New Wedding</title>
</head>
<body>
<div class="container">
<form:form action="/weddings/new" method="post" modelAttribute="wedding">
<form:input type="hidden" value="${user_id}" path="user"/>
<div class="form-group">
<form:label path="guestOne">guestOne</form:label>
<form:errors path="guestOne"/>
<form:input path="guestOne" type="text"/>
</div>
<div class="form-group">
<form:label path="guestTwo">guestTwo</form:label>
<form:errors path="guestTwo"/>
<form:input path="guestTwo" type="text"/>
</div>
<div class="form-group">
<form:label path="date">Date</form:label>
<form:errors path="date"/>
<form:input path="date" type="date"/>
</div>
<div class="form-group">
<form:label path="address">Address</form:label>
<form:errors path="address"/>
<form:input path="address"/>
</div>
<button>Create Wedding</button>


</form:form>
</div>
</body>
</html>
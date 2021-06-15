<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>
<h3>Categories: </h3>
<ul>
<c:forEach items="${product.categories}" var="category">
<li>${category.name}</li>
</c:forEach>
</ul>
<form:form action="/products/${product.id}" method="post" modelAttribute="category">
<select name="category">
<c:forEach items="${categories}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</select>
<input type="submit" value="Add"/>
</form:form>
<a href="/categories/new">Click here to add a new category</a>
</body>
</html>
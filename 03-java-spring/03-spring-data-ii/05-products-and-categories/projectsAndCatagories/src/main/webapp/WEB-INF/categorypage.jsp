<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<h1><c:out value="${category.name }"/></h1>
<h3>Products: </h3>
<ul>
<c:forEach items="${categories.products}" var="product">
<li>${product.name}</li>
</c:forEach>
</ul>
<form:form action="/categories/${category.id }" method="post" modelAttribute="product">
<select name="product">
<c:forEach items="${products}" var="product">
<option value="${product.id}">${product.name }</option>
</c:forEach>
</select>
<input type="submit" value="Add"/>
</form:form>
<a href="/products/new">Click here to add a new Product</a>
</body>
</html>
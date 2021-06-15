<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Persons and Licenses</h1>
<a href="/persons/new">Create a Person</a> |  <a href="/licenses/new">Create a License</a>

<table>
<thead>
<tr>
<th>id</th>
<th>first name</th>
<th>last name</th>
</tr>
</thead>
<tbody>
<c:forEach items="${persons}" var="person">
<tr>
<td>${person.id}</td>
<td>${person.firstName}</td>
<td>${person.lastName}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
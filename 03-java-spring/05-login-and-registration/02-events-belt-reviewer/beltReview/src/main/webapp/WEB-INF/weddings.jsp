<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weddings Homepage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Let's plan a wedding</h2> | <a href="/logout">Logout</a>
<table>
<tr>
<th>Wedding</th>
<th>Date</th>
<th>Guests</th>
<th>Action</th>
</tr>
<tbody>
<c:forEach items="${allWeddings}" var="wedding">
<tr>
<td>${wedding.guestOne} & ${wedding.guestTwo}</td>
<td><fmt:formatDate value="${wedding.date}" pattern="MMM dd, yyyy"/></td>
<td>${wedding.guests.size()}</td>
<td>
<c:choose>
<c:when test="${wedding.guests.contains(user)}">
<a href="/unrsvp/${wedding.id}">UnRSVP</a></c:when>
<c:otherwise>
<a href="/rsvp/${wedding.id}">RSVP</a></c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>
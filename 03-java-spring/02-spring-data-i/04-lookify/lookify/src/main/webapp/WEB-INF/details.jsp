<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>

<h3>Song title: <c:out value="${song.title}"/></h3>
<h3>Song artist: <c:out value="${song.artist}"/></h3>
<h3>Song rating: <c:out value="${song.rating}"/></h3>
<a href="/songs/delete/${song.id}">Delete</a>


</body>
</html>
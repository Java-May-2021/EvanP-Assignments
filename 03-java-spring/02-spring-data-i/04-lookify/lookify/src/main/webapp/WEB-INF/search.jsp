<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Artist</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h3>Songs by artist:${artist}</h3>
<form method="post" action="/search">
<input type="text" name="artist"/>
<button>New Search</button>
</form>

<table>
	<thead>
		<tr>
		<th>Title</th>
		<th>Rating</th>
		<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${songs}" var="song">
	<tr>
		<td><a href="/songs/${song.id}">${song.title}</a></td>
		<td>${song.rating}</td>
		<td><a href="/songs/delete/${song.id}">Delete</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>
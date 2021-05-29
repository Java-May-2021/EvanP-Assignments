<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java</title>
</head>
<body>
<h1>That's my favorite language too!</h1>
<h3>Submitted Info</h3>
<label>Name: </label> <c:out value="${name}"/> <br>
<label>Dojo Location: </label> <c:out value="${location}"/> <br>
<label>Favorite Language: </label> <c:out value="${language}"/> <br>
<label>Comments: </label> <c:out value="${comment}"/> <br>
<form action="/" method="POST">
<button>Go Back</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1><c:out value="${error}"/></h1>
<form action="/code" method="POST">
<h2>What is the code?</h2>
<input type="text" name="guess">
<button type="submit">Try Code</button>
</form>
</body>
</html>
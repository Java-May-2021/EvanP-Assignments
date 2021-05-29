<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
<h1>Welcome to the Dojo Survey!</h1>
<form action="/result" method="POST">
<label>Your Name: </label>
<input type="text" name="name">
<br>
<label>Dojo Location:</label>
<select name="location">
<option value="San Jose">San Jose</option>
<option value="Seattle">Seattle</option>
<option value="Dallas">Dallas</option>
</select>
<br>
<label>Favorite Language</label>
<select name="language">
<option value="Python">Python</option>
<option value="Java">Java</option>
<option value="Mern">Mern</option>
</select>
<br>
<label>Comment (optional): </label>
<input type="text" name="comment">
<br>
<button>Submit</button>
<br>
</form>
</body>
</html>
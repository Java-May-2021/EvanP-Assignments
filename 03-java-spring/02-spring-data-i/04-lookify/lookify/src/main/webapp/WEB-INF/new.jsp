<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add a new song!</h2>
<a href="/dashboard">Dashboard</a>
<form:form action="/dashboard" method="POST" modelAttribute="song">
	<p>
	<form:label path="title">Title: </form:label>
	<form:input path="title"/>
	<form:errors path="title"/>
	</p>
	<p>
	<form:label path="artist">Artist: </form:label>
	<form:input path="artist"/>
	<form:errors path="artist"/>
	</p>
	<p>	
	<form:label path="rating">Rating: </form:label>
	<form:input path="rating"/>
	<form:errors path="rating"/>
	</p>
	
	<button>Submit new song</button>

</form:form>

</body>
</html>
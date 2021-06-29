<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<div class="container">
<a href="/questions">Dashboard</a><br>
<h1>What is your question?</h1>
<c:forEach items="${errors}" var="err">
<h4>${err}</h4>
</c:forEach>

<form:form action="/questions/new" method="POST" modelAttribute="question">
<div class="form-group row">
<form:label path="question">Question:
<form:errors path="question"/>
<form:textarea class="form-control" type="text" path="question" value="${question.question}"/></form:label>
</div>

<div class="form-group row">
<form:label path="tags">Tags:
<form:errors path="tags"/>
<form:input class="form-control" type="text" path="tags" value="${question.stTags}"/></form:label>
</div>
			
<button class="btn btn-primary">Submit</button>
</form:form>
		
</div>
</body>
</html>
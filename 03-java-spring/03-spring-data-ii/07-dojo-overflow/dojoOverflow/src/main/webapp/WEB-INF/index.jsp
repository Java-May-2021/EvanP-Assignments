<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
<div class="container">
<h1>Questions Dashboard</h1>
<hr>
<table class="table table-dark">
<thead>
<tr>
<td>Question</td>
<td>Tags</td>
</tr>
</thead>
<tbody>
<c:forEach items="${allQuestions}" var="question">
<tr>
<td>${question.id}"</td>
<td>${question.question}</td>
<td><c:forEach items="${question.tags}" var="tags"><c:out value="${tag.subject}"/></c:forEach></td>
<td><a href="/questions/${question.id}">Answer</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<h4><a href="questions/new">Add a question</a></h4>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Profile</title>
</head>
<body>
<div class="container">
<h1>${question.question}</h1>
<h3>Tags: </h3>
<ul>
<c:forEach items="${question.tags}" var="tag">
	<li>${tag.subject}</li>
</c:forEach>
</ul>
<table class="table table-dark">
<thead>
<tr>
<th>Answers: </th>
</tr>
</thead>
<tbody>
<tr>
<td>
<ul>
<c:forEach items="${question.answers}" var="answer">
	<li>"${answer.answer}"</li>
</c:forEach>
</ul>
</tr>
</tbody>
</table>
<h3>Add your Answer: </h3>
<c:forEach items="${errors}" var="err">
<h4>${err}</h4>
</c:forEach>
<form:form action="/questions/answers" method="post" modelAttribute="answer">
<form:hidden path="question" value="${question.id}"/>
<div class="form-group">
<form:label path="answer">Answer: </form:label>
<form:errors path="answer"/>
<form:textarea path="answer" class="form-control" type="text" value="${answer.answer}"></form:textarea>
</div>
<button class="btn btn-primary">Answer it!</button>
</form:form><br>
</div>

</body>
</html>
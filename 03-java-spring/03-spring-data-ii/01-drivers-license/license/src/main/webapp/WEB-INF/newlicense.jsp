<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new License</title>
</head>
<body>
<h1>Create a new License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
<p>
<form:label path="person">Select Person</form:label>
<form:errors path="person"/>
<form:select path="person">
<c:forEach items="${unlicensed}" var="person">
<option value="${person.id}">${person.firstName} ${person.lastName}</option>
</c:forEach>
</form:select>
</p>
<p>
<form:label path="expirationDate">Expiration Date</form:label>
<form:errors path="expirationDate"/>
<form:input type="date" path="expirationDate"/>
</p>
<p>
<form:label path="state">State</form:label>
<form:errors path="state"/>
<form:input path="state"/>
</p>
<button>Create new License</button>
</form:form>

</body>
</html>
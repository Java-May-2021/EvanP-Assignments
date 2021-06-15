<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h1>${person.firstName} ${person.lastName}</h1>
<p>License Number: ${person.license.returnLicenseNumber() }</p>
<p>Expiration Date: ${person.license.expirationDate } </p>
<p>State: ${person.license.state }</p>
</body>
</html>
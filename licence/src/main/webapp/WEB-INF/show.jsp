<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMV App</title>
</head>
<body>
	<h1>${ person.firstName } ${ person.lastName }</h1>
	<hr>
	<p><strong>License Number</strong> ${ person.license.getNumberAsString() }</p>
	<p><strong>Exiration Date</strong> ${person.license.exirationDate } </p>
	<p><strong>State</strong> ${person.license.state } </p>
</body>
</html>
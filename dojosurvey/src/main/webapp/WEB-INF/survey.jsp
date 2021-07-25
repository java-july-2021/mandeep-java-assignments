<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<p>Name:<c:out value="${ name }"/></p>
	<p>Language:<c:out value="${ language }"/></p>
	<p>Location:<c:out value="${ location }"/></p>
	<p>Comment:<c:out value="${ comment }"/></p>
</body>
</html>
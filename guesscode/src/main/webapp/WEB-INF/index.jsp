<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The code</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	
	<form action="/attempt" method="POST">
		<span><c:out value="${ error }" /></span>
		<h3>What is the code?</h3>
		<input type="text" name="guess" placeholder="Print code here.." />
		<button>Try Code</button>
	</form>
</body>
</html>
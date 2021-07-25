<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<link rel="stylesheet" type="text/css" href= "/css/style1.css">
<script src="js/main.js"></script>
</head>
<body>
	<script>timeAlert()</script>
	<p><c:out value="${currentTime}"/></p>
</body>
</html>
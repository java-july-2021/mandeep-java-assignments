<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Dojo</title>
</head>
<body>
	<h1>Create Dojo</h1>
	<hr>
	<form:form action="/dojo/createDojo" method="POST" modelAttribute="dojo">
	<p>
	<form:label path="name">Dojo Name</form:label>
	<form:errors path="name"/>
	<form:input class="form-control" path="name"/>
	</p>
	<button>Create Dojo</button>
	</form:form>	
</body>
</html>
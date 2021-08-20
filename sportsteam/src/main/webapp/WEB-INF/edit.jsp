<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Edit Team</h1>
	<hr>
	<form:form method="POST" action="/edit/${team.id}" modelAttribute="team">
	<div class="form-group">
	<form:label path="teamName">Team Name</form:label>
	<form:errors path="teamName"/>
	<form:input type="text" path="teamName"/>
	</div>
	<div class="form-group">
	<form:label path="city">City</form:label>
	<form:errors path="city"/>
	<form:input type="text" path="city"/>
	</div>
	<div class="form-group">
	<form:label path="sport">Sport</form:label>
	<form:errors path="sport"/>
	<form:input type="text" path="sport"/>
	</div>
	<div class="form-group">
	<form:label path="budget">Budget</form:label>
	<form:errors path="sport"/>
	<form:input type="number" path="budget"/>
	</div>
	<div class="form-group">
	<form:label path="isActive">Is Active?</form:label>
	<form:errors path="isActive"/>
	<form:select path="isActive">
	<option value="true">Active</option>
	<option value="false">Not Active</option>
	</form:select>
	</div>
	<button>Edit Team</button>
	</form:form>
	</div>
</body>
</html>
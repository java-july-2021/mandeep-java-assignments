<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Sports Team Dot Com</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Welcome To Sports Team Dot Com</h1>
	<hr>
	<div class="row">
	<div class="col">
	<h2>Login</h2>
	<p>${error}</p>
	<form method="POST" action="/login">
	<div class="form-group">
	<label for="email">Email</label>
	<input type="text" name="loginemail">
	</div>
	<div class="form-group">
	<label for="password">Password</label>
	<input type="text" name="loginpassword">
	</div>
	<button>Login</button>
	</form>
	</div>
	<div class="col">
		<h2>Register</h2>
		<form:form action="/register" method="post" modelAttribute="user">
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName"/>
				<form:input class="form-control" path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName"/>
				<form:input class="form-control" path="lastName"/>
			</div>
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email"/>
				<form:input type="email" class="form-control" path="email"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password"/>
				<form:input type="password" class="form-control" path="password"/>
			</div>
			<div class="form-group">
				<form:label path="conformPassword">Conform Password</form:label>
				<form:errors path="conformPassword"/>
				<form:input type="conformPassword" class="form-control" path="conformPassword"/>
			</div>
			<input class="btn btn-danger" type="submit" value="Submit"/>
		</form:form>
	</div>
	</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Owned</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
	<h1>Welcome To Sports Team Dot Com</h1>
	<a href="/new">Add Team To Database</a> | <a href="/player/new">Add Player</a> | <a href="/logout">Logout</a>
	<hr>
	<h3>User Detail for ${user.firstName} ${user.lastName}</h3>
	<hr>
	<h5>Team Owned:</h5>
	<ul>
	<c:forEach items="${user.teamsOwned}" var="team">
	<li><a href="/${team.id}">${team.teamName}</a>
	</li>
	</c:forEach>
	</ul>
</body>
</html>
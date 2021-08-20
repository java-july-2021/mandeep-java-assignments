<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Go Team</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Details For ${team.teamName}</h1>
	<p>Owned By: ${team.owner.firstName}</p>
	
	<c:forEach items="${team.rating}" var="rate">
	<c:if test="${rate.user == user }">
	<p>You Rated this: ${rate.rating}</p>
	</c:if>
	</c:forEach>
	<hr>
	<h3>Liked By</h3>
	<c:forEach items="${team.likers}" var="user">
	<p>${user.firstName} ${user.lastName}</p>
	</c:forEach>
	<p>Name: ${team.teamName}</p>
	<p>City: ${team.city}</p>
	<p>Sport: ${team.sport}</p>
	<p>Budget: ${team.budget}</p>
	<p>IsActive: ${team.isActive}</p>
	<hr>
	<h2>Players</h2>
	<hr>
	<ul>
	<c:forEach items="${team.players}" var="player">
	<p>FirstName: ${player.firstName}</p>
	<p>LastName: ${player.lastName}</p>
	<p>Salary: ${player.salary}</p>
	</c:forEach>
	</ul>
	<c:if test="${team.owner.id == user.id}">
	<a href="/edit/${team.id}" style="btn btn-primary">Edit Team</a> | <a href="/delete/${team.id}" style="btn btn-primary">Delete Team</a>
	</c:if>
	</div>
</body>
</html>
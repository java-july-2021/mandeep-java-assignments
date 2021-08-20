<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome To Sports Team Dot Com</title>
</head>
<body>
	<div class="container">
	<a href="/new">Add Team To Database</a> | <a href="/player/new">Add Player</a> | <a href="/logout">Logout</a>
	<table class="table table dark">
	<thead>
	<tr>
	<th>Action</th>
	<th>Team Name</th>
	<th>City</th>
	<th>Sport</th>
	<th>Budget</th>
	<th>Is Active?</th>
	<th># of Likers</th>
	<th>Average Rating</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${allTeams}" var="team">
	<tr>
	<td>
	<c:choose>
	<c:when test = "${team.likers.contains(user)}">
	<a href="/unlike/${team.id}">UnLike</a>
	</c:when>
	<c:otherwise>
	<a href="/like/${team.id}">Like</a>
	</c:otherwise>
	</c:choose>
	</td>
	<td><a href="/${team.id}">${team.teamName}</a></td>
	<td>${team.city}</td>
	<td>${team.sport}</td>
	<td><fmt:formatNumber type="number" value="${team.budget}"></fmt:formatNumber></td>
	<td>${team.isActive}</td>
	<td>${team.likers.size()}</td>
	<td>
	<c:set var="sum" value = "${0}"/>
	<c:forEach items="${team.rating}" var="rate">
	<c:if test="${team.rating.size() != 0 }">
	<c:set var="sum" value="${sum + rate.rating}"/>
	</c:if>
	</c:forEach>
	<c:if test="${sum > 0}">
	<c:set var="sum" value="${sum / team.rating.size() }"/>
	</c:if>
	<c:out value="${sum}"/>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>
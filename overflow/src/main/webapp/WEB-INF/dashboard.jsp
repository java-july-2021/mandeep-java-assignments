<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
	<thead>
	<tr>
	<th>Question</th>
	<th>Tags</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${allqs}" var="q">
	<tr>
	<td><a href="/show/${q.qtags}">${q.qtext}</a></td>
	<td>
	<p>
	<c:forEach items="${q.qtags}" var="tagtext">
	${tagtext.subject},
	</c:forEach>
	</p>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>
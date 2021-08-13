<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Dashboard</title>
</head>
<body>
	<h1>${ question.qtext }?</h1>
	<h3>Tags:</h3>
	<ul>
	<c:forEach items="${ question.qtags }" var="tag">
	<li>${ tag.subject }</li>
	</c:forEach>
	</ul>
	<h3>Answers:</h3>
	<ul>
		<c:forEach items="${ question.answers }" var="answer">
			<li>${ answer.atext }</li>		
		</c:forEach>
		</ul>
		<hr>
		<h3>Add your answer:</h3>
		<form:form method="POST" action="/addAnswer" modelAttribute="answer">
		<p>
		<form:label path="atext">Answer:</form:label>
		<form:errors path="atext"/>
		<form:input path="atext"/>
		<form:hidden path="quest" value="${question.id}"/>
		</p>
		<button>Add Answer</button>
		</form:form>
</body>
</html>
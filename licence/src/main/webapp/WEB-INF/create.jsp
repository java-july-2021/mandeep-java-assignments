<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMV App</title>
</head>
<body>
	<h1>New License</h1>
	<hr>
	<form:form action="/licenses" method="POST" modelAttribute="license">
	<p>
	<form:label path="person">Person</form:label>
	<form:errors path="person"/>
	<form:select class="form-control" path="person">
	<c:forEach items="${ persons }" var="p">
	<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
	</c:forEach>
	</form:select>
	</p>
	<p>
	<form:label path="state">State</form:label>
	<form:errors path="state"/>
	<form:input class="form-control" path="state"/>
	</p>
	<p>
	<form:label path="exirationDate">Expiration Date</form:label>
	<form:errors path="exirationDate"/>
	<form:input type="date" class="form-control" path="exirationDate"/>
	</p>
	<button>Add License</button>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ninja</title>
</head>
<body>
	<h1>Create Ninja</h1>
	<form:form action="/ninja/createNinja" method="POST" modelAttribute="ninja">
	<p>
	<form:label path="dojo">Dojo Name</form:label>
	<form:errors path="dojo"/>
	<form:select class="form-control" path="dojo">
	<c:forEach items="${ dojos }" var="doj">
	<option value="${ doj.id }">${ doj.name }</option>
	</c:forEach>
	</form:select>
	</p>
	<p>
	<form:label path="firstName">First Name</form:label>
	<form:errors path="firstName"/>
	<form:input class="form-control" path="firstName"/>
	</p>
	<p>
	<form:label path="lastName">Last Name</form:label>
	<form:errors path="lastName"/>
	<form:input class="form-control" path="lastName"/>
	</p>
	<p>
	<form:label path="age">Age</form:label>
	<form:errors path="age"/>
	<form:input class="form-control" path="age"/>
	</p>
	<button>Create Ninja</button>
	</form:form>
</body>
</html>
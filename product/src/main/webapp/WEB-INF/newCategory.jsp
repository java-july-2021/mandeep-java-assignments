<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>
	<h2>Create Category</h2>
	<form method="POST" action="/newCat">
	<p>
	<label for="name">Name</label>
	<input type="text" name="cat">
	</p>
	<p>
	<button>Create Category</button>
	</p>
	</form>
</body>
</html>
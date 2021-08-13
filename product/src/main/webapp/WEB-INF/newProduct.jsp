<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Product</title>
</head>
<body>
	<h2>Create Product</h2>
	<form method="POST" action="/newProd">
	<p>
	<label for="name">Name</label>
	<input type="text" name="name">
	</p>
	<p>
	<label for="description">Description</label>
	<textarea name="desc"></textarea>
	</p>
	<p>
	<label for="price">Price</label>
	<input type="number" name="price" step="0.01">
	</p>
	<p>
	<button>Create Product</button>
	</p>
	</form>
</body>
</html>
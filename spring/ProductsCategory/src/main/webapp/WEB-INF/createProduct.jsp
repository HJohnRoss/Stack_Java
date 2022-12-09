<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<a href="/">dashboard</a>
		<div>
			<form:form action="/product/create/success" method="post" modelAttribute="product">
					<form:errors path="name"></form:errors>
				<div>
					<form:label path="name">Name:</form:label>
					<form:input path="name" type="text"></form:input>
				</div>
					<form:errors path="description"></form:errors>
				<div>
					<form:label path="description">Description:</form:label>
					<form:input path="description" type="text"></form:input>
				</div>
					<form:errors path="price"></form:errors>
				<div>
					<form:label path="price">Price:</form:label>
					<form:input path="price" input="text"></form:input>
				</div>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>
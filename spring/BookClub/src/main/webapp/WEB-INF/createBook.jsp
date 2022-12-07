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
    <title>Create a Book!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/dashboard">Back to the shelves</a>
		</div>
		<form:form action="/book/create/success" method="post" modelAttribute="newBook">
			<input type="hidden" value="${userId }" name="user"></input>
			<form:errors path="title" class="text-danger"></form:errors>
			<div>
				<form:label path="title">Title</form:label>
				<form:input path="title" type="text"></form:input>		
			</div>
			<form:errors path="author" class="text-danger"></form:errors>
			<div>
				<form:label path="author">author</form:label>
				<form:input path="author" type="input"></form:input>
			</div>
			<form:errors path="thought" class="text-danger"></form:errors>
			<div>
				<form:label path="thought">thought</form:label>
				<form:textarea path="thought"></form:textarea>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>
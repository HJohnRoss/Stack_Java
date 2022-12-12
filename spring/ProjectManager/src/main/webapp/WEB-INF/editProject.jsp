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
		<h1>Edit Project</h1>
		<a href="/dashboard">dashboard</a>
		
		<form:form action="/project/edit/${oneProject.id }/success" method="post" modelAttribute="oneProject">
			<input type="hidden" name="_method" value="put"/>
			<form:input type="hidden" path="user"></form:input>
			<form:errors path="title" class="text-danger"></form:errors>
			<div>
				<form:label path="title">Title:</form:label>
				<form:input path="title" type="text"></form:input>
			</div>
			<form:errors path="description" class="text-danger"></form:errors>
			<div>
				<form:label path="description">Description:</form:label>
				<form:input path="description" type="text"></form:input>
			</div>
			<form:errors path="date" class="text-danger"></form:errors>
			<div>
				<form:label path="date">Date:</form:label>
				<form:input path="date" type="date"></form:input>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>
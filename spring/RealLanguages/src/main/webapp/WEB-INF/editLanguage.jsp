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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="d-flex gap-3 mb-2">
			<a href="/">Go Back</a>
			<a href="/language/show/${id}">show</a>
			<form action="/language/delete/${id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-danger">
			</form>
		</div>
		<form:form action="/language/update/${id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
			<div>
				<form:label path="name">Name</form:label>
				<form:errors action="name"></form:errors>
				<form:input path="name"></form:input>
			</div>
			
			<div>
				<form:label path="creator">creator</form:label>
				<form:errors action="creator"></form:errors>
				<form:input path="creator"></form:input>
			</div>
			
			<div>
				<form:label path="version">version</form:label>
				<form:errors action="version"></form:errors>
				<form:input path="version"></form:input>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>
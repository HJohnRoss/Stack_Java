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
		
		<div class="d-flex justify-content-between">
			<h1>Edit Expense</h1>
			<a href="/">Go Back</a>
		</div>
		
		<form:form action="/language/${id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
			<div>
				<form:label path="expense">expense</form:label>
				<form:errors path="expense"/>
				<form:input path="expense"/>
			</div>
			
			<div>
				<form:label path="vendor">vendor</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input path="vendor" type="text"/>
			</div>
			
			<div>
				<form:label path="amount">amount</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input path="amount" type="text"/>
			</div>
			
			<div>
				<form:label path="description">description</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:input path="description" type="text"/>
			</div>
			<button class="btn btn-primary">Submit</button>
		
		</form:form>
		
		
		
	</div>
	
</body>
</html>
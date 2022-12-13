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
		<div class="d-flex justify-content-between">
			<div>
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<form:errors path="firstName" class="text-danger"></form:errors>
					<div>
						<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName" type="text"></form:input>
					</div>
					<form:errors path="lastName" class="text-danger"></form:errors>
					<div>
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName" type="text"></form:input>
					</div>
					<form:errors path="email" class="text-danger"></form:errors>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input path="email" type="text"></form:input>
					</div>
					<form:errors path="password" class="text-danger"></form:errors>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input path="password" type="password"></form:input>
					</div>
					<form:errors path="confirm" class="text-danger"></form:errors>
					<div>
						<form:label path="confirm">Confirm Password:</form:label>
						<form:input path="confirm" type="password"></form:input>
					</div>
					<button class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div>
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<form:errors path="email" class="text-danger"></form:errors>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input path="email" type="text"></form:input>
					</div>
					<form:errors path="password" class="text-danger"></form:errors>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input path="password" type="password"></form:input>
					</div>
					<button class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
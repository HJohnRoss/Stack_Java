<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Welcome!</h1>
		<h4>Join our growing community.</h4>

		<h1>Register</h1>
		<div class="d-flex justify-content-between">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div>
					<form:label path="userName">User Name</form:label>
					<form:errors path="userName" class="text-danger" />
					<form:input path="userName" type="text" />
				</div>
				<div>
					<form:label path="email">Email</form:label>
					<form:errors path="email" class="text-danger" />
					<form:input path="email" type="text" />
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:errors path="password" class="text-danger" />
					<form:input path="password" type="password" />
				</div>
				<div>
					<form:label path="confirm">Confirm Password</form:label>
					<form:errors path="confirm" class="text-danger" />
					<form:input path="confirm" type="password" />
				</div>
				<button class="btn btn-primary">Submit</button>
			</form:form>

			<div>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<h1>Login</h1>
					<div>
						<form:label path="email">Email</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input path="email" type="text" />
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:errors path="password" />
						<form:input path="password" type="password" />
					</div>
					<button class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
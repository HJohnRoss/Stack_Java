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
		<h1>Edit Sighting</h1>
		<a href="/dashboard">dashboard</a>
		<a href="/logout">logout</a>
		
		<form:form action="/sighting/edit/${oneSighting.id }/success" method="post" modelAttribute="oneSighting">
			<input type="hidden" name="_method" value="put"/>
			<form:input type="hidden" path="user"></form:input>
			<form:input type="hidden" path="users"></form:input>
			<form:errors path="location" class="text-danger"></form:errors>
			<div>
				<form:label path="location">Location:</form:label>
				<form:input path="location" type="text"></form:input>
			</div>
			<form:errors path="what" class="text-danger"></form:errors>
			<div>
				<form:label path="what">What Happened:</form:label>
				<form:input path="what" type="text"></form:input>
			</div>
			<form:errors path="date" class="text-danger"></form:errors>
			<div>
				<form:label path="date">Date:</form:label>
				<form:input path="date" type="date"></form:input>
			</div>
			<form:errors path="num" class="text-danger"></form:errors>
			<div>
				<form:label path="num"># of sasquatches:</form:label>
				<form:input path="num" type="date"></form:input>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>
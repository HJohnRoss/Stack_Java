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
		<h1>Dorms</h1>
			<p>
				<a href="/dorm/create">Add a new dorm</a> <br />
				<a href="/student/create">Add a new Student</a> <br />
				<a href="/class/create">Add a new class</a> <br />
				<a href="/classes">View All classes</a>
			</p>
		
		<table class="table table-dark">
			<tr>
				<th>Dorm</th>
				<th>Action</th>
			</tr>
			<c:forEach var="oneDorm" items="${allDorms }">
				<tr>
					<td><c:out value="${oneDorm.name }"></c:out></td>
					<td><a href="/show/dorm/${oneDorm.id }">See Students</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
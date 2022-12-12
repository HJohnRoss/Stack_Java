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
		<h1>Project: <c:out value="${oneProject.title }"></c:out></h1>
		<h4>Project Lead: <c:out value="${oneProject.user.firstName }"></c:out></h4>
		<a href="/dashboard">dashboard</a>
		
		<form:form action="/project/${oneProject.id }/tasks/success" method="post" modelAttribute="task" class="mb-5">
			<form:errors path="name" class="text-danger"></form:errors>
			<div>
				<form:label path="name">Add a task Ticket for this team:</form:label>
				<form:input path="name" type="input"></form:input>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
		
		<c:forEach var="oneTask" items="${oneProject.tasks }">
			<h5>Added by <c:out value="${oneTask.creator.firstName }"></c:out>
			<fmt:formatDate value="${oneTask.createdAt}" pattern="hh:mm MMMM dd" />
			</h5>
			<p><c:out value="${oneTask.name }"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>
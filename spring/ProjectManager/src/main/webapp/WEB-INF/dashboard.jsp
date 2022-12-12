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
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex gap-5">
			<h1>Welcome, <c:out value="${userName }"></c:out>!</h1>
			<a href="/logout">log out</a>
		</div>
		<div class="d-flex justify-content-between">
			<h4>All Projects</h4>
			<a href="/project/create">+ New Project</a>
		</div>
		<table class="table table-dark mb-5">
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="oneProject" items="${unassignedProjects }">
				<c:if test="${oneProject.user.id != userId }">
					<tr>
						<td><a href="/project/show/${oneProject.id }"><c:out
									value="${oneProject.title }"></c:out></a></td>
						<td><c:out value="${oneProject.user.firstName }"></c:out></td>
						<td><fmt:formatDate value="${oneProject.date}"
								pattern="MMMM dd" /></td>
						<td><a href="/team/join/${oneProject.id }">join team</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<h3>Your Projects</h3>
		<table class="table table-dark">
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="oneProject" items="${oneUser.projects }">
				<tr>
					<td><a href="/project/show/${oneProject.id }"><c:out
								value="${oneProject.title }"></c:out></a></td>
					<td><c:out value="${oneProject.user.firstName }"></c:out></td>
					<td><fmt:formatDate value="${oneProject.date}"
							pattern="MMMM dd" /></td>
					<td><a href="/project/edit/${oneProject.id}">edit</a></td>
				</tr>
			</c:forEach>
			<c:forEach var="oneProject" items="${assignedProjects }">
				<tr>
					<td><a href="/project/show/${oneProject.id }"><c:out
								value="${oneProject.title }"></c:out></a></td>
					<td><c:out value="${oneProject.user.firstName }"></c:out></td>
					<td><fmt:formatDate value="${oneProject.date}"
							pattern="MMMM dd" /></td>
					<td><a href="/team/leave/${oneProject.id}">Leave Team</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
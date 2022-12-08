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
		<div class="d-flex justify-content-between mb-5">
			<h1><c:out value="${oneBook.title }"></c:out></h1>
			<a href="/dashboard">dashboard</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${oneBook.user.id == userId }">
					<h4>
						<c:out value="${oneBook.user.name }"></c:out>
						read <c:out value="${oneBook.title }"></c:out>
						by <c:out value="${oneBook.author }"></c:out> 
					</h4>
				</c:when>
			</c:choose>
			<h4>
				Here are 
				<c:out value="${oneBook.user.name }"></c:out>'s thoughts:
			</h4>
			<p><c:out value="${oneBook.thought }"></c:out></p>
		</div>
		<c:choose>
			<!-- if -->
			<c:when test="${oneBook.user.id == userId }">
				<a href="/book/edit/${oneBook.id }">edit</a>
				<form action="/book/delete/${oneBook.id }" method="post">
				   <input type="hidden" name="_method" value="delete">
 				   <input type="submit" value="Delete">
				</form>
			</c:when>
			<!-- else -->
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
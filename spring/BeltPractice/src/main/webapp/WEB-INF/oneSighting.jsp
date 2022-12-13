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
		<div>
			<h1>Sasquatch Sighting</h1>
			<h1><c:out value="${userName }"></c:out></h1>
				<a href="/dashboard">Dashboard</a>
				<a href="">Logout</a>
		</div>
		<div>		
			<p>Project: <c:out value="${oneSighting.location }"></c:out></p>
			<p>What Happened: <c:out value="${oneSighting.what }"></c:out></p>
			<p>Due Date: <fmt:formatDate value="${oneSighting.date}" pattern="MM/dd/YYYY"/></p>
			<p># of Sasquatches: <c:out value="${oneSighting.num }"></c:out></p>
			<p>Reported By: <c:out value="${oneSighting.user.firstName }"></c:out></p>
		</div>
		<div>
			<h2>Skeptics:</h2>
			<ul>
				<c:forEach var="oneUser" items="${oneSighting.users }">
					<li><c:out value="${oneUser.firstName }"></c:out> <c:out value="${oneUser.lastName }"></c:out></li>					
				</c:forEach>
			</ul>
			<c:choose>
				<c:when test="${!oneSighting.users.contains(loggedUser)}">
					<form action="/skeptic/add/${oneSighting.id }" method="post">
						<input type="hidden" name="_method" value="put"/>
						<button class="btn btn-success">Skeptik</button>
					</form>
				</c:when>
				<c:otherwise>
					<form action="/skeptic/remove/${oneSighting.id }" method="post">
						<input type="hidden" name="_method" value="put"/>
						<button class="btn btn-danger">Believe</button>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
</body>
</html>
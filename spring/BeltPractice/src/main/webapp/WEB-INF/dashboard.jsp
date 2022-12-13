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
		<div class="d-flex gap-5">
			<h1>
				Welcome,
				<c:out value="${userName }"></c:out>
				!
			</h1>
			<a href="/create/sighting">create sighting</a>
			<a href="/logout">log out</a>
		</div>
		
		<c:forEach var="oneSighting" items="${allSightings }">
			<div class="border">
				<div class="d-flex gap-5">
					<p>
						Skeptiks: <br />
						<c:out value="${oneSighting.users.size() }"></c:out>
					</p>
					<p>
						Sighted at <c:out value="${oneSighting.location }"></c:out> on <fmt:formatDate value="${oneSighting.date}" pattern="MMMM dd" /> <br />
						Reported By: <c:out value="${oneSighting.user.firstName }"></c:out>
					</p>
				</div>
				<div>
				<c:choose>
					<c:when test="${oneSighting.user.id == userId}">
						<a class="btn btn-primary" href="/sighting/edit/${oneSighting.id}">edit</a>
						<form action="/sighting/delete/${oneSighting.id }" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<button class="btn btn-danger">Delete</button>
						</form>
					</c:when>
					
					<c:otherwise>
						<a class="btn btn-success" href="/sighting/show/${oneSighting.id}">veiw</a>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
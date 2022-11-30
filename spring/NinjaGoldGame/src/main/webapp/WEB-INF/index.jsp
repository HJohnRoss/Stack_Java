<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
	<h3>Your Gold: <c:out value="${ total}"/></h3> <!-- add total -->
	<div class="d-flex justify-content-evenly">
	
		<form action="/gold" method="post">
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<input class="button" type="submit" name="farm" value="Find Gold!"/>
		</form>
	
		<form action="/gold" method="post">
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<input class="button" type="submit" name="cave" value="Find Gold!"/>
		</form>
	
		<form action="/gold" method="post">
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<input class="button" type="submit" name="house" value="Find Gold!"/>
		</form>
	
		<form action="/gold" method="post">
			<h3>Quest</h3>
			<p>(earns/takes <br> 0-50 gold)</p>
			<input class="button" type="submit" name="quest" value="Find Gold!"/>
		</form>
	</div>
	
	<h3>Activities: </h3>
	<c:forEach var="action" items="${actions }">
		<c:if test = "${action.contains('earned')}" >
			<p class="text-success"><c:out value="${action}"/></p>
		</c:if>
		<c:if test = "${action.contains('lost') }">
			<p class="text-danger"><c:out value="${action }"/></p>
		</c:if>
	</c:forEach>
	<!-- for loop later to show activities -->
</div>
</body>
</html>

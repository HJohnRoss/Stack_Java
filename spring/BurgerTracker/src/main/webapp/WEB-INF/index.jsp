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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	
		<h1>Burger Tracker</h1>
	
		<table class="table table-dark">
		
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
			</tr>
			
			<c:forEach var="oneBurger" items="${allBurgers }">
			
				<tr>
					<td><a href="/burger/edit/${oneBurger.id}"><c:out value="${oneBurger.burgerName }"/></a></td>
					<td><c:out value="${oneBurger.restaurantName }"/></td>
					<td><c:out value="${oneBurger.rating }"/></td>
				</tr>
				
			</c:forEach>

			
			
		</table>
		
		<h2>Add a Burger:</h2>
		<form:form action="/burger/create" method="post" modelAttribute="burger">
		
		<div>
			<form:label path="burgerName">Burger Name</form:label>
			<form:errors path="burgerName" class="text-danger"/>
			<form:input path="burgerName" type="text"/>
		</div>
		<div>
			<form:label path="restaurantName">Restaurant Name</form:label>
			<form:errors path="restaurantName" class="text-danger"/>
			<form:input path="restaurantName" type="text"/>
		</div>
		<div>
			<form:label path="rating">Rating</form:label>
			<form:errors path="rating" class="text-danger"/>
			<form:input path="rating" type="number"/>
		</div>
		<div>
			<form:label path="note">Notes</form:label>
			<form:errors path="note" class="text-danger"/>
			<form:textarea path="note"></form:textarea>
		</div>
		<button>Submit</button>
		
		</form:form>
	
	</div>
	
</body>
</html>
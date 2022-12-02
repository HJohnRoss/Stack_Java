<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
		<h1>Edit Burger</h1>
		
		<form:form action="/burger/${burger.id }" method="post" modelAttribute="burger">
			<input type="hidden" name="_method" value="put">
			<div>
				<form:label path="burgerName">Burger Name</form:label>
				<form:errors path="burgerName"/>
				<form:input path="burgerName"/>
			</div>
			
			<div>
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:errors path="restaurantName" class="text-danger"/>
				<form:input path="restaurantName" type="text"/>
			</div>
			
			<div>
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating"/>
				<form:textarea path="rating"></form:textarea>
			</div>
			
			<div>
				<form:label path="note">Notes</form:label>
				<form:errors path="note"/>
				<form:input path="note"/>
			</div>
			
			<button>Submit</button>
		</form:form>
	
	</div>
</body>
</html>
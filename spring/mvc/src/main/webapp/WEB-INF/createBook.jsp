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
	<form:form action="/book/create/success" method="post" modelAttribute="book">
		<div>
			<form:label  path="title">title:</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" type="text"/>
		</div>
		<div>
			<form:label  path="description">description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description"/>
		</div>
		<div>
			<form:label  path="language">language:</form:label>
			<form:errors path="language" class="text-danger"/>
			<form:input path="language" type="text"/>
		</div>
		<div>
			<form:label path="numberOfPages">Number of Pages:</form:label>
			<form:errors path="numberOfPages" class="text-danger"/>
			<form:input path="numberOfPages" type="number"/>
		</div>
		<button>Submit</button>
		
	</form:form>
</body>
</html>
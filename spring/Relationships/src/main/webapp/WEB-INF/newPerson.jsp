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
    <title>New Person</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   	<div class="container">
   		<h1>New Person</h1>
   		<form:form action="/person/create" method="post" modelAttribute="person">
   			<div>
	   			<form:label path="firstName">First Name: </form:label>
	   			<form:errors path="firstName" class="text-danger"></form:errors>
	   			<form:input path="firstName" type="text"/>
	   		</div>
	   		<div>
	   			<form:label path="lastName">Last Name: </form:label>
	   			<form:errors path="lastName" class="text-danger"></form:errors>
	   			<form:input path="lastName"/>
	   		</div>
	   		<button class="btn btn-primary">Submit</button>
   		</form:form>
   	</div>
</body>
</html>
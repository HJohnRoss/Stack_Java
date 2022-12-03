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
		<h1>Save Travels</h1>
		
		<table class="table table-dark">
		
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
			
			
			<c:forEach var="oneLanguage" items="${allLanguages}">
				<tr>
					<td><a href="/language/show/${oneLanguage.id }"><c:out value="${oneLanguage.expense}"></c:out></a></td>
					<td><c:out value="${oneLanguage.vendor }"></c:out></td>
					<td><c:out value="${oneLanguage.amount }"></c:out></td>
					<td class="d-flex gap-3">
						<a href="/language/edit/${oneLanguage.id }">edit</a>
						<form action="/language/delete/${oneLanguage.id }" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<button class="btn btn-danger">delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		
		</table>
		
		<h2>Add an expense:</h2>
		
		<form:form action="/language/create" method="post" modelAttribute="language">
			<div>
				<form:label path="expense">Expense Name:</form:label>
				<form:errors path="expense" class="text-danger"></form:errors>
				<form:input path="expense" type="text"/>
			</div>
			<div>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger"></form:errors>
				<form:input path="vendor" type="text"/>
			</div>
			<div>
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="text-danger"></form:errors>
				<form:input path="amount" type="number"/>				
			</div>
			<div>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger"></form:errors>
				<form:textarea path="description"></form:textarea>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>
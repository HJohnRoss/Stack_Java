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
		<div class="d-flex justify-content-between">
			<h4>Hello, <c:out value="${userName}"></c:out>, Welcome to..</h4>
			<a href="/dashboard">dashboard</a>
		</div>
		<div>
			<h1>The Book Broker!</h1>
			<h4>Available Books to Borrow</h4>
		</div>
		<table class="table table-dark">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="oneBook" items="${allBooks }">		
				<tr>
					<td><c:out value="${oneBook.id }"></c:out></td>
					<td><c:out value="${oneBook.title }"></c:out></td>
					<td><c:out value="${oneBook.author }"></c:out></td>
					<td><c:out value="${oneBook.user.name }"></c:out></td>
					<td>
						<a href="/borrow/add/${oneBook.id }">borrow</a>
						
						<a href="/bookmarket/edit/${oneBook.id }">edit</a>
						<form action="/book/delete/${oneBook.id }" method="post">
					   		<input type="hidden" name="_method" value="delete">
			 				<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<h4>Books I'm Borrowing</h4>
		<table class="table table-dark">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="oneBorrow" items="${oneUser.borrows } }">
				sad
			</c:forEach>
		</table>
	</div>
</body>
</html>
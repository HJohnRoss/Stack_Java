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
		<h1><c:out value="${oneCategory.name }"></c:out></h1>
		<a href="/">Dashboard</a>
		<div class="mt-5">
			<h3>Products</h3>
			<ul>
				<c:forEach var="oneProduct" items="${oneCategory.products }">
					<li><a href="/product/show/${oneProduct.id }"><c:out value="${oneProduct.name }"></c:out></a></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<c:if test="${someProducts != [] }">
			<h3>Add Product:</h3>
			<form action="/product/add/${oneCategory.id}" method="post">
				<select name="product">
					<c:forEach var="oneProduct" items="${someProducts}">
							<option value="${oneProduct.id}"><c:out value="${oneProduct.name }"></c:out></option>
					</c:forEach>
				</select>
				<button class="btn btn-primary">Submit</button>
			</form>
			</c:if>
		</div>
	</div>
</body>
</html>
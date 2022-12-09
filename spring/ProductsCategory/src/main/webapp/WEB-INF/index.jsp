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
		<h1>Home Page</h1>
		
		<p>
			<a href="/product/create">New Product</a> <br>
			<a href="/category/create">New Category</a>
		</p>
		
		<div class="d-flex gap-5">
			<div class="border p-5">
				<h1>Products</h1>
				<ul>
					<c:forEach var="oneProduct" items="${allProducts }">
						<li><a href="/product/show/${oneProduct.id }"><c:out value="${oneProduct.name }"></c:out></a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="border p-5">
			<h1>Categories</h1>
				<ul>
					<c:forEach var="oneCategory" items="${allCategories }">
						<li><a href="/category/show/${oneCategory.id }"><c:out value="${oneCategory.name }"></c:out></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
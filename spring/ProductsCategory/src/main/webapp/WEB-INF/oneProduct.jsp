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
		<h1><c:out value="${oneProduct.name }"></c:out></h1>
		<a href="/">dashboard</a>
		
		<div>
			<h4>Categories:</h4>
			<ul>
				<c:forEach var="category" items="${oneProduct.categories }">
					<li><a href="/category/show/${category.id }"><c:out value="${category.name }"></c:out></a></li>
				</c:forEach>
			</ul>
		</div>
		
		<form action="/category/add/${oneProduct.id }" method="post">
			<select name="categoryId" id="">
				<c:forEach var="oneCategory" items="${someCategories }">
					<option value="${oneCategory.id }"><c:out value="${oneCategory.name }"></c:out></option>
				</c:forEach>
			</select>
			<button>Submit</button>
		</form>
	</div>
</body>
</html>
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
		<h1><c:out value="${oneStudent.name }"></c:out>'s classes</h1>
		<a href="/">dashboard</a>
		
		<c:if test="${someClasses != [] }">
			<form action="/class/add/${oneStudent.id }" method="post">
				<label>add class:</label>
				<select name="classId">
					<c:forEach var="oneClass" items="${someClasses }">
						<option value="${oneClass.id }"><c:out value="${oneClass.name }"></c:out></option>
					</c:forEach>
				</select>
				<button class="btn btn-primary">Submit</button>
			</form>
		</c:if>
		
		<table class="table table-dark">
			<tr>
				<th>Class Name</th>
				<th>Action</th>
			</tr>
			<c:forEach var="oneClass" items="${oneStudent.classes}">
				<tr>
					<td><c:out value="${oneClass.name }"></c:out></td>
					<td>
						<form action="/class/delete/${oneStudent.id }" method="post">
							<input name="classId" type="hidden" value="${oneClass.id }"/>
							<button class="btn btn-danger">Drop</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
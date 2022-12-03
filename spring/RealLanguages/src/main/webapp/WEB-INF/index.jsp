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
		<table class="table table-striped table-dark">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			
			
			<c:forEach var="oneLanguage" items="${allLanguages }">
				<tr>
					<td><a href="/language/show/${oneLanguage.id}"><c:out value="${oneLanguage.name }"></c:out></a></td>
					<td><c:out value="${oneLanguage.creator }"></c:out></td>
					<td><c:out value="${oneLanguage.version }"></c:out></td>
					<td class="d-flex gap-3">
						<form action="/language/delete/${id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete" class="btn btn-danger">
						</form>
						<a href="/language/edit/${oneLanguage.id }">edit</a>
					</td>	
				</tr>
			</c:forEach>
		</table>
		
		<form:form action="/language/create" method="post" modelAttribute="language">
			<div>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name" type="text"/>
			</div>
			
			<div>
				<form:label path="creator">creator:</form:label>
				<form:errors path="creator" class="text-danger"/>
				<form:input path="creator" type="text"/>
			</div>
			
			<div>
				<form:label path="version">version:</form:label>
				<form:errors path="version" class="text-danger"/>
				<form:input path="version" type="text"/>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>
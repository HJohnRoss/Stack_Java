<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>
			<c:out value="${oneDorm.name }" />
			Students
		</h1>
		<a href="/">Dashboard</a>

		<div>
			<form action="/student/create/${oneDorm.id }" method="post">

				<label>Students:</label> <select name="studentId">
					<c:forEach var="student" items="${someStudents }">

						<option value="${student.id }">
							<c:out value="${student.name }" />
						</option>

					</c:forEach>
				</select>
				<button>Submit</button>
			</form>
		</div>

		<table class="table table-dark">
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
			<c:forEach var="student" items="${oneDorm.students }">
				<td><c:out value="${student.name }" /></td>
				<td>
					<form action="/student/delete/${student.id }" method="post">
						<input type="hidden" name="method_" value="delete"> <input
							type="submit" value="Delete" class="btn btn-danger">
					</form>
				</td>
			</c:forEach>
		</table>
	</div>
</body>
</html>
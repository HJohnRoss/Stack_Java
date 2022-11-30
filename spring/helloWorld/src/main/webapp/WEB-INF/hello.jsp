<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>HELLO THERE</h1>
		<% for (int i = 0; i < 5; i++){ %>
			<h1><%= i %></h1>
		<% } %>
		<h1>User Name:</h1>
		<h2><c:out value="${name}"/></h2>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<table class="border">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="oneFruit" items="${fruits }">
		<tr>
			<th class="border-top"><c:out value="${oneFruit.name}"></c:out></th>
			<th class="border-top"><c:out value="${oneFruit.price}"></c:out></th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
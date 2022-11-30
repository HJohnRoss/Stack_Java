<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Customer Name: <c:out value="${name}"></c:out></h1>
		<h3>Item name: <c:out value="${itemName }"></c:out></h3>
		<h3>Price: <c:out value="${price }"></c:out> </h3>
		<h3>Description: <c:out value="${description }"></c:out></h3>
		<h3>Vendor: <c:out value="${vendor }"></c:out></h3>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<p>You have visited <c:out value="${count}"></c:out> <a href="/your_server">back</a></p>
	<a href="/your_server/counter">Test another visit?</a>
	<a href="/reset">Reset</a>
	<a href="/by_two">increase by 2</a>
</body>
</html>
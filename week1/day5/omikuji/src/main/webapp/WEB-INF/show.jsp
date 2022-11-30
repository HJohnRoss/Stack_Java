<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show</title>
</head>
<body>
	<h1>Heres Your Omikuji</h1>
	<div>
		<p>
			In <c:out value="${num }"/>, you will<br>
			live in <c:out value="${city }"/> with<br>
			<c:out value="${name }"/> as your<br>
			roommate, <c:out value="${hobby }"/><br>
			The next time you<br>
			see a <c:out value="${living }"/>, you will<br>
			have good luck.<br>
			Also, you do not realize how happy<br>
			you make others.
		</p>
		
	</div>
</body>
</html>
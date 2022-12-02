<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
	<a href="/book/create">add a book!</a>
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Language</th>
			<th># Pages</th>
		</tr>
		<c:forEach var="oneBook" items="${allBooks}">
			<tr>
				<td><c:out value="${oneBook.id}"/></td>
				<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title }"/></a></td>
				<td><c:out value="${oneBook.language}"/></td>
				<td><c:out value="${oneBook.numberOfPages}"/></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
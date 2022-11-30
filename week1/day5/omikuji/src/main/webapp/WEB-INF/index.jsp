<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<form action="/show/submit" method="POST" >
		<p>Pick any number from 5 to 25</p>
		<input name="num" type="number">
		<p>Enter the name of any city</p>
		<input name="city" type="text">
		<p>Enter the name of any real person</p>
		<input name="name" type="text">
		<p>Enter professional endeavor or hobby</p>
		<input name="hobby" type="text">
		<p>Enter any living thing</p>
		<input name="living" type="text">
		<p>Say something nice to someone</p>
		<textarea name="nice"></textarea>
		<button>submit</button>
	</form>
</body>
</html>
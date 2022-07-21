<%@ page import="com.reply.eu.BooksList"%>
<%@ page import="com.reply.eu.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="left">Books list</h1>
	<table border="1">
		<thead>
			<tr>
				<td>id</td>
				<td>Title</td>
				<td>Author</td>
				<td> Actions</td>
			</tr>
		</thead>
		<c:forEach var="book" items="${BooksList.bookList}">
			<tr>
				<td>${book.getId()}</td>
				<td>${book.getTitle()}</td>
				<td>${book.getAuthor()}</td>
				<td> <a href='/ServletLog/updateBook?id=<c:out value="${book.getId()}"/>'>Update book</a> <br>
				<a href='/ServletLog/deleteBook?id=<c:out value="${book.getId()}"/>'>Delete book</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/ServletLog/createBook.html">Add new book</a>
</body>
</html>
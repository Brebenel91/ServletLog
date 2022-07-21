<%@ page import="com.reply.eu.BooksList"%>
<%@ page import="com.reply.eu.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Book book2update = BooksList.bookList.get(Integer.parseInt(request.getParameter("id"))); 
if (Integer.parseInt(request.getParameter("id")) < 0
&& Integer.parseInt(request.getParameter("id")) >= BooksList.bookList.size()){
	response.setStatus(Response.SC_BAD_REQUEST);
}
%>
	<form action="updateBook" method="post">
		id:  <input readonly type="text" name="id" value=<%= book2update.getId() %>><br>
		title: <input type="text" name="title" value="<%= book2update.getTitle() %>"><br> 
		author: <input type="text" name="author" value="<%= book2update.getAuthor() %>"><br>
		<input type="submit">
	</form>
	
</body>
</html>
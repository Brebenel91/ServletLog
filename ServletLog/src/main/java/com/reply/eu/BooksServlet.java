package com.reply.eu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BooksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("readBooks.jsp");
		
//		if (BooksList.bookList == null) {
//			response.setStatus(Response.SC_BAD_REQUEST);
//		} else {
//			for (Book b : BooksList.bookList) {
//				//response.getWriter().println(b);
//				
//			}
//		}
		
//		PrintWriter out = response.getWriter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		for (Book b : BooksList.bookList) {
//			String bookJson = objectMapper.writeValueAsString(b);
//			out.println(bookJson);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Book book = new Book(request.getParameter("title"), request.getParameter("author"));
		if (book.getTitle() == null || book.getAuthor() == null) {
			response.setStatus(Response.SC_BAD_REQUEST);
		} else {
			BooksList.bookList.add(book);
			response.sendRedirect("readBooks.jsp");
		}
		
//		if ("application/json".equals(request.getHeader("content-type"))) {
//			ObjectMapper objectMapper = new ObjectMapper();
//			String body = Services.getBody(request);
//			Book book = objectMapper.readValue(body, Book.class);
//			BooksList.bookList.add(book);
//		} else {
//			response.setStatus(Response.SC_BAD_REQUEST);
//		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Integer.parseInt(request.getParameter("id")) >= 0
				&& Integer.parseInt(request.getParameter("id")) < BooksList.bookList.size()) {
			BooksList.bookList.get(Integer.parseInt(request.getParameter("id")))
					.setTitle(request.getParameter("title"));
			BooksList.bookList.get(Integer.parseInt(request.getParameter("id")))
					.setAuthor(request.getParameter("author"));
		} else {
			response.setStatus(Response.SC_BAD_REQUEST);
		}

//		if ("application/json".equals(request.getHeader("content-type"))) {
//			ObjectMapper objectMapper = new ObjectMapper();
//			String body = Services.getBody(request);
//			Book book = objectMapper.readValue(body, Book.class);
//			if (book.getId() <= BooksList.bookList.size() || book.getId() >= 0) {
//				BooksList.bookList.get(book.getId()).setTitle(book.getTitle());
//				BooksList.bookList.get(book.getId()).setAuthor(book.getAuthor());
//			} else {
//				response.setStatus(Response.SC_BAD_REQUEST);
//			}
//		} else {
//			response.setStatus(Response.SC_BAD_REQUEST);
//		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (Integer.parseInt(request.getParameter("id")) >= 0
				&& Integer.parseInt(request.getParameter("id")) < BooksList.bookList.size()) {
			BooksList.bookList.remove(Integer.parseInt(request.getParameter("id")));
		}

//		if ("application/json".equals(request.getHeader("content-type"))) {
//			ObjectMapper objectMapper = new ObjectMapper();
//			String body = Services.getBody(request);
//			Book book = objectMapper.readValue(body, Book.class);
//			if (book.getId() <= BooksList.bookList.size() || book.getId() >= 0) {
//				BooksList.bookList.remove(book.getId());
//			} else {
//				response.setStatus(Response.SC_BAD_REQUEST);
//			}
//		} else {
//			response.setStatus(Response.SC_BAD_REQUEST);
//		}
	}
}

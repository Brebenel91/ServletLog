package com.reply.eu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BooksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		for (Book b : BookList.bookList) {
			String bookJson = objectMapper.writeValueAsString(b);
			out.println(bookJson);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book(Integer.parseInt(request.getParameter("id")), request.getParameter("title"),
				request.getParameter("author"));
		BookList.bookList.add(book);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookList.bookList.get(id).setTitle(request.getParameter("title"));
		BookList.bookList.get(id).setAuthor(request.getParameter("author"));
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookList.bookList.remove(id);
	}

}

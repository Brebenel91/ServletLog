package com.reply.eu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import com.reply.eu.BooksList;
import com.reply.eu.Services;
import com.reply.eu.model.Book;
import com.reply.eu.service.BookService;

@WebServlet("/books")
public class BooksServlet extends HiddingResourceServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Book book = new Book(request.getParameter("title"), request.getParameter("author"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String isbn = request.getParameter("isbn");
		if (title  == null || author == null || genre == null || isbn == null) {
			response.setStatus(Response.SC_BAD_REQUEST);
		} else {
			//BooksList.bookList.add(book);
			BookService bookService = new BookService();
			bookService.createBook(title, author, genre, isbn);
			response.sendRedirect("/ServletLog/books");
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Services.verifyId(request, response);

		Book book = BooksList.bookList.get(id);
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		response.sendRedirect("/books");

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Services.verifyId(request, response);
		BooksList.bookList.remove(id);
		response.sendRedirect("/books");

	}

	@Override
	protected String getResourcePath() {
		// TODO Auto-generated method stub
		return "readBooks.jsp";
	}
}
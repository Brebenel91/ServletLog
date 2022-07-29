package com.reply.eu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.eu.Services;
import com.reply.eu.service.BookService;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String isbn = request.getParameter("isbn");
		
		Services.verifyId(request, response);
		BookService bs = new BookService();
		bs.updateBook(id, title, author, genre, isbn);
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/readBooks.jsp");
		reqDisp.forward(request, response);
		// response.sendRedirect("readBooks.jsp");
	}
}

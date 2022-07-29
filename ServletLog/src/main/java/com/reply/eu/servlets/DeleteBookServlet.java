package com.reply.eu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.eu.BooksList;
import com.reply.eu.Services;
import com.reply.eu.service.BookService;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Services.verifyId(req, resp);
		BookService bs = new BookService();
		bs.deleteBook(id);
		resp.sendRedirect("/ServletLog/books");
	}
}
package com.reply.eu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (Integer.parseInt(req.getParameter("id")) >= 0
				&& Integer.parseInt(req.getParameter("id")) < BooksList.bookList.size()) {
			BooksList.bookList.remove(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("readBooks.jsp");
		}
	}

	
}

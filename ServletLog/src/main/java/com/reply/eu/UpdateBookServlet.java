package com.reply.eu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
	}
}

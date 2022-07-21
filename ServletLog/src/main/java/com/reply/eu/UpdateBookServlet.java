package com.reply.eu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Integer.parseInt(request.getParameter("id")) >= 0
				&& Integer.parseInt(request.getParameter("id")) < BooksList.bookList.size()
				&& request.getParameter("id") != null) {
			Book book2update = BooksList.bookList.get(Integer.parseInt(request.getParameter("id")));

//					.setTitle(request.getParameter("title"));
//			BooksList.bookList.get(Integer.parseInt(request.getParameter("id")))
//					.setAuthor(request.getParameter("author"));

			StringBuilder out = new StringBuilder();
			out.append("<body>\r\n" + "	<form action=\"updateBook\" method=\"post\">\r\n"
					+ "		id:  <input type=\"text\" name=\"id\" value=\"");
			out.append(book2update.getId());
			out.append("\"><br>\r\n" + "		title: <input type=\"text\" name=\"title\" value=\"");
			out.append(book2update.getTitle());
			out.append("\"><br> \r\n" + "		author: <input type=\"text\" name=\"author\" value=\"");
			out.append(book2update.getAuthor());
			out.append(
					"\"><br> \r\n" + "		<input type=\"submit\">\r\n" + "	</form>\r\n" + "	\r\n" + "</body>");
			PrintWriter pw = response.getWriter();
			pw.write(out.toString());
		} else {
			response.setStatus(Response.SC_BAD_REQUEST);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Integer.parseInt(request.getParameter("id")) >= 0
				&& Integer.parseInt(request.getParameter("id")) < BooksList.bookList.size()) {
			BooksList.bookList.get(Integer.parseInt(request.getParameter("id")))
					.setTitle(request.getParameter("title"));
			BooksList.bookList.get(Integer.parseInt(request.getParameter("id")))
					.setAuthor(request.getParameter("author"));

			RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/readBooks.jsp");
			reqDisp.forward(request, response);
			//response.sendRedirect("readBooks.jsp");
		} else {
			response.setStatus(Response.SC_BAD_REQUEST);
		}
	}
}

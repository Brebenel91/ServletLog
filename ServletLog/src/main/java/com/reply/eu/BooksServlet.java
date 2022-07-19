package com.reply.eu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.annotation.WebServlet;



/**
 * Servlet implementation class BooksServlet
 */
//@WebServlet("/books")
public class BooksServlet extends HttpServlet {
	
	private static List<Book> listBooks=new ArrayList<Book>();
	private int CONTOR=0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(listBooks.isEmpty()){
			response.getWriter().println("The list is empty.");
		}else{
			response.getWriter().println("There are "+listBooks.size()+" books.");
			for(Book b:listBooks) {
				response.getWriter().println(b);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listBooks.add(new Book(++CONTOR,request.getParameter("isbn"), request.getParameter("authorName"), request.getParameter("publisher")));
		response.getWriter().println("The book was successfully added to the list.");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contor=Integer.parseInt(request.getParameter("ID"));
		String changeIsbn=request.getParameter("changeIsbnWith");
		String changeAuthorName=request.getParameter("changeAuthorNameWith");
		String changePublisher=request.getParameter("changePublisherWith");
		if(listBooks.size()!=0 && contor<=listBooks.size()) {
		Book book=listBooks.get(contor-1);
		book.setIsbn(changeIsbn);
		book.setAuthorName(changeAuthorName);
		book.setPublisher(changePublisher);
		response.getWriter().println("The book was successfully updated.");
		} else {
			response.getWriter().println("The ID you mentioned doesn't exist.");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contor=Integer.parseInt(request.getParameter("ID"));

		for(Book book:listBooks) {
			if(contor==book.getID()) {
				this.listBooks.remove(book);
			}
		}
	}
	

}

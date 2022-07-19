package com.reply.eu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/books")
public class BooksServlet extends HttpServlet {
	
	private static List<Book> listBooks=new ArrayList<Book>();
	private int CONTOR=0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=new Book(++CONTOR,request.getParameter("isbn"), request.getParameter("authorName"), request.getParameter("publisher"));
		listBooks.add(book); 
		for(Book b:listBooks) {
			response.getWriter().println("Book #"+ b.getID() +" isbn= "+b.getIsbn()+" "+" authorName= "+b.getAuthorName()+" "+" publisher= "+b.getPublisher());
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contor=Integer.parseInt(request.getParameter("ID"));
		String changeIsbn=request.getParameter("changeIsbnWith");
		String changeAuthorName=request.getParameter("changeAuthorNameWith");
		String changePublisher=request.getParameter("changePublisherWith");
		for(Book book:listBooks) {
			if(contor==book.getID()) {
				book.setIsbn(changeIsbn);
				book.setAuthorName(changeAuthorName);
				book.setPublisher(changePublisher);
			}
		}
		for(Book b:listBooks) {
			response.getWriter().println("Book #"+ b.getID() +" isbn= "+b.getIsbn()+" "+" authorName= "+b.getAuthorName()+" "+" publisher= "+b.getPublisher());
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

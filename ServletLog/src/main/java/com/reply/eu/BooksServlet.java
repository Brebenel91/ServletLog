package com.reply.eu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import javax.servlet.annotation.WebServlet;



/**
 * Servlet implementation class BooksServlet
 */
//@WebServlet("/books")
public class BooksServlet extends HttpServlet {
	
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		if(BooksList.booksList.isEmpty()){
			response.getWriter().println("The list is empty.");
		}else{
			response.getWriter().println("There are "+BooksList.booksList.size()+" books.");
			for(Book b:BooksList.booksList) {
				String bookJson =  mapper.writeValueAsString(b);
				response.getWriter().println(bookJson);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ObjectMapper mapper = new ObjectMapper();
		  
		if(("json").equalsIgnoreCase(request.getContentType())) {
			String body = Service.getBody(request);
			TypeReference<Book> typeRef= new TypeReference<Book>() {};
			Book obj = mapper.readValue(body, typeRef);
			BooksList.booksList.add(obj);
		}else {
			response.setStatus(Response.SC_BAD_REQUEST);
		}
		
		
//		response.getWriter().println("The book was successfully added to the list.");
		
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contor=Integer.parseInt(request.getParameter("ID"));
		String changeIsbn=request.getParameter("changeIsbnWith");
		String changeAuthorName=request.getParameter("changeAuthorNameWith");
		String changePublisher=request.getParameter("changePublisherWith");
		for(Book book:BooksList.booksList) {
			if(contor==book.getID()) {
				book.setIsbn(changeIsbn);
				book.setAuthorName(changeAuthorName);
				book.setPublisher(changePublisher);
			}
		}
		for(Book b:BooksList.booksList) {
			response.getWriter().println(b);
			}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contor=Integer.parseInt(request.getParameter("ID"));

		for(Book book:BooksList.booksList) {
			if(contor==book.getID()) {
				BooksList.booksList.remove(book);
			}
		}
	}
	

}

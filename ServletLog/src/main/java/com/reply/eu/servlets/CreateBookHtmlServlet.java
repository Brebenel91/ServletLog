package com.reply.eu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createNewBook")
public class CreateBookHtmlServlet extends HiddingResourceServlet {
	

	@Override
	protected String getResourcePath() {
		
		return "createBook.html";
	}
}

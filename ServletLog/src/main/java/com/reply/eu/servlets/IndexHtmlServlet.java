package com.reply.eu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class IndexHtmlServlet extends HiddingResourceServlet {
	private static final long serialVersionUID = 1L;
      

	@Override
	protected String getResourcePath() {
		
		return "index.html";
	}

	

}

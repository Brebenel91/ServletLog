package com.reply.eu.servlets;

import javax.servlet.annotation.WebServlet;


@WebServlet("/updateABook")
public class UpdateBookJspServlet extends HiddingResourceServlet {
	private static final long serialVersionUID = 1L;
      
	
	@Override
	protected String getResourcePath() {
		
		return "updateBook.jsp";
	}

}

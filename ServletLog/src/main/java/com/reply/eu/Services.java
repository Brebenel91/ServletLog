package com.reply.eu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class Services {

	public static String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}

	public static int verifyId(HttpServletRequest request, HttpServletResponse response) throws IOException {

		if (request.getParameter("id") == null) {
			response.setStatus(Response.SC_BAD_REQUEST);
			response.getWriter().write("Missing parameter");
		}
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.setStatus(Response.SC_BAD_REQUEST);
			response.getWriter().write("Id is not a number");
		}

		if (id < 0 || id >= BooksList.bookList.size()) {
			response.setStatus(Response.SC_BAD_REQUEST);
			response.getWriter().write("Book id not found");
		}
		return id;
	}
}

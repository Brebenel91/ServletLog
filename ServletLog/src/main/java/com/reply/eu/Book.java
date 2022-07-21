package com.reply.eu;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private static int counter;
	private int id;
	private String title;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String title, String author) {
		this();
		this.title = title;
		this.author = author;
	}

	public Book() {
		super();
		id = counter++;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}

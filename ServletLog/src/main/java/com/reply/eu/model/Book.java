package com.reply.eu.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private static int counter;
	private int id;
	private String title;
	private String author;
	private String genre;
	private String isbn;

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	public Book(int id, String title, String author, String genre, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
	}

	
	public Book(String title, String author, String genre, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
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

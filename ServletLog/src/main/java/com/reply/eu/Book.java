package com.reply.eu;

public class Book {
	
	private int bookID;
	private String isbn;
	private String authorName;
	private String publisher;
	
	public Book() {}
	
	public Book(int bookID,String isbn, String authorName, String publisher) {
		this.bookID=bookID;
		this.isbn=isbn;
		this.authorName=authorName;
		this.publisher=publisher;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getAuthorName() {
		return this.authorName;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public int getID() {
		return this.bookID;
	}
	
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName=authorName;
	}
	
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
	
	public void setID(int bookID) {
		this.bookID=bookID;
	}
	
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("Book #"+this.getID()+" isbn= "+this.getIsbn()+" authorName= "+this.getAuthorName()+" publisher= "+this.getPublisher());
		return stringBuilder.toString();
	}
	
	
	
	

}

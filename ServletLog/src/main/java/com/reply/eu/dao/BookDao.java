package com.reply.eu.dao;

import java.util.List;

import com.reply.eu.model.Book;

public interface BookDao <T, I> {
	List<T> getAllBooks();
	
	T getBookById(I id);
	
	void deleteBook(I id);
	
	T updateBook(T b);
	
	T createBook(T b);
}

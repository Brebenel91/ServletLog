package com.reply.eu.service;


import java.util.List;


import com.reply.eu.dao.BookDaoDB;
import com.reply.eu.model.Book;

public class BookService {
	
	//Singleton pentru BookDao
	private final BookDaoDB bookDao = BookDaoDB.getInstance();

	public Book createBook(String title, String author, String genre, String isbn) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setIsbn(isbn);
		return  bookDao.createBook(book);

	}

	public Book updateBook(int id,String title, String author, String genre, String isbn) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setIsbn(isbn);
		return bookDao.updateBook(book);
	}

	public void deleteBook(int id) {

		bookDao.deleteBook(id);
	}

	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}
}

package com.reply.eu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reply.eu.model.Book;

public class BookDaoDB implements BookDao<Book, Integer> {

	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String U_NAME = "libraryUser";
	private static final String PASSWORD = "root";
	private static Connection con = null;
	private static final String SELECT_STATEMENT = "SELECT * FROM books";
	private static final String SELECT_STATEMENT_BY_ID = "SELECT id, title, author, genre, isbn FROM books WHERE id=?";
	private static final String DELETE_STATEMENT_BY_ID = "DELETE FROM books WHERE id=?";
	private static final String UPDATE_STATEMENT_BY_ID = "UPDATE books SET title=?, author=?, genre=?, isbn=? WHERE id=?";
	private static final String INSERT_STATEMENT = "INSERT INTO books (title, author, genre, isbn) VALUES (?, ?, ?, ?)";
	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String AUTHOR = "author";
	private static final String GENRE = "genre";
	private static final String ISBN = "isbn";
	private static BookDaoDB INSTANCE;
	private static final Object MUTEX = new Object(); // VARIANTA 1
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, U_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// VARIANTA 3 - cu bloc static si cu metoda getInstance() ca sa returnam
	// obiectul - fara synchronized
	/*
	 * static { INSTANCE = new BookDaoDB(); }
	 * 
	 * public static BookDaoDB getInstance() { return INSTANCE; }
	 */

	private BookDaoDB() {

	}

	// VARIANTA 1 - To access a critical section, a thread acquires the mutex, then
	// accesses the critical section, and finally releases the mutex. In the
	// meantime, all other threads block till the mutex releases. As soon as a
	// thread exits the critical section, another thread can enter the critical
	// section.
	public static BookDaoDB getInstance() {
		if (INSTANCE == null) {
			synchronized (MUTEX) {
				if (INSTANCE == null)
					INSTANCE = new BookDaoDB();
			}
		}
		return INSTANCE;
	}

	// VARIANTA 2 - cu synchronized pe metoda
	/*
	 * public static synchronized BookDaoDB getInstance() { if(INSTANCE == null)
	 * INSTANCE = new BookDaoDB(); return INSTANCE; }
	 */

	// VARIANTA 4 - daca e accesata de mai multe thread-uri in acelasi timp, o sa
	// creeze mai multe instance-uri (useful pentru single threading)
	/*
	 * public static BookDaoDB getInstance() { if(INSTANCE == null) { INSTANCE = new
	 * BookDaoDB(); } return INSTANCE; }
	 */

	@Override
	public List<Book> getAllBooks() {
		List<Book> booksList = new ArrayList<>();

		// closes rs and st in reverse order
		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SELECT_STATEMENT);) {

			while (rs.next()) {

				Book book = new Book();
				book.setId(rs.getInt(ID));
				book.setTitle(rs.getString(TITLE));
				book.setAuthor(rs.getString(AUTHOR));
				book.setGenre(rs.getString(GENRE));
				book.setIsbn(rs.getString(ISBN));

				booksList.add(book);

			}

			return booksList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = new Book();

		try (PreparedStatement pst = con.prepareStatement(SELECT_STATEMENT_BY_ID);) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				book.setId(rs.getInt(ID));
				book.setTitle(rs.getString(TITLE));
				book.setAuthor(rs.getString(AUTHOR));
				book.setGenre(rs.getString(GENRE));
				book.setIsbn(rs.getString(ISBN));
			}
			return book;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(Integer id) {

		try (PreparedStatement pst = con.prepareStatement(DELETE_STATEMENT_BY_ID)) {
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book updateBook(Book b) {

		try (PreparedStatement pst = con.prepareStatement(UPDATE_STATEMENT_BY_ID);) {
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getGenre());
			pst.setString(4, b.getIsbn());
			pst.setInt(5, b.getId());
			pst.executeUpdate();
			return b;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book createBook(Book b) {

		try (PreparedStatement pst = con.prepareStatement(INSERT_STATEMENT);) {
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getGenre());
			pst.setString(4, b.getIsbn());
			pst.executeUpdate();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

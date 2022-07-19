package com.reply.eu;

import java.util.ArrayList;
import java.util.List;

public class BookList {
	public static List<Book> bookList = new ArrayList();
	static {
		bookList.add(new Book(0, "Amintiri din copilarie", "Ion Creanga"));
		bookList.add(new Book(1, "Shogun", "James Clavell"));
		bookList.add(new Book(2, "Arta razboiului", "Sun Tzu"));
	}

}

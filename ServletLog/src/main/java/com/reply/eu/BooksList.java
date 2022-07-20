package com.reply.eu;

import java.util.ArrayList;
import java.util.List;

public class BooksList {
	public static List<Book> bookList = new ArrayList();
	static {
		bookList.add(new Book("Amintiri din copilarie", "Ion Creanga"));
		bookList.add(new Book("Shogun", "James Clavell"));
		bookList.add(new Book("Arta razboiului", "Sun Tzu"));
	}
}

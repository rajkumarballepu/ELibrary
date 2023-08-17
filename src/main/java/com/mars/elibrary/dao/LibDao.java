package com.mars.elibrary.dao;

import java.util.List;

import com.mars.elibrary.entity.Book;
import com.mars.elibrary.entity.Borrower;
import com.mars.elibrary.entity.Librarian;

public interface LibDao {
	void addLibrarian(Librarian librarian);

	List<Librarian> getLibrarians();

	Librarian getLibrarian(int id);

	void updateLibrarian(Librarian librarian);

	Librarian librarian(String email, String password);

	void addBook(Book book);

	List<Book> getBooks();

	Book getBook(int book_id);

	void issueBook(Borrower borrower);

	List<Borrower> getBorrowers();

	int returnBook(Borrower borrower);
}

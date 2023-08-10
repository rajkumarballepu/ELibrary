package com.mars.elibrary.dao;

import java.util.List;

import com.mars.elibrary.entity.Book;
import com.mars.elibrary.entity.Librarian;

public interface LibDao {
	void addLibrarian(Librarian librarian);

	List<Librarian> getLibrarians();

	Librarian getLibrarian(int id);

	void updateLibrarian(Librarian librarian);

	Librarian librarian(String email, String password);

	void addBook(Book book);
}

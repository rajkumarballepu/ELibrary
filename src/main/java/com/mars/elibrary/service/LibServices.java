package com.mars.elibrary.service;

import java.util.List;

import com.mars.elibrary.entity.Librarian;

public interface LibServices {
	void addLibrarian(Librarian librarian);
	List<Librarian> getLibrarians();
}

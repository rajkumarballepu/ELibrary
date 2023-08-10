package com.mars.elibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mars.elibrary.dao.LibDao;
import com.mars.elibrary.entity.Librarian;

@Component
public class LibServicesImp implements LibServices {
	
	@Autowired
	private LibDao libDao;
	
	@Override
	public void addLibrarian(Librarian librarian) {
		libDao.addLibrarian(librarian);
	}

	@Override
	public List<Librarian> getLibrarians() {
		return libDao.getLibrarians();
	}

}

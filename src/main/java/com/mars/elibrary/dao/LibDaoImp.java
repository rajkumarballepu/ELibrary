package com.mars.elibrary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.elibrary.entity.Book;
import com.mars.elibrary.entity.Librarian;
@Component
public class LibDaoImp implements LibDao {

	@Autowired
	private JdbcTemplate template;

//	@Autowired
//	private RowMapper<Book> bookMapper;
	
	@Autowired
	private RowMapper<Librarian> librarianMapper;
	
	@Override
	public void addLibrarian(Librarian librarian) {
		template.update("insert into lbrns (name,mobile,email,password) values (?,?,?,?)",librarian.getName(),librarian.getNumber(),librarian.getEmail(),librarian.getPassword());
	}

	@Override
	public List<Librarian> getLibrarians() {
		List<Librarian> librarians = template.query("select * from lbrns", librarianMapper);
		return librarians;
	}

	@Override
	public Librarian getLibrarian(int id) {
		Librarian librarian = template.queryForObject("select * from lbrns where id = ?",librarianMapper, id);
		return librarian;
	}

	@Override
	public void updateLibrarian(Librarian librarian) {
		template.update("update lbrns set name=?, mobile=?, email=? where id = ?",librarian.getName(), librarian.getNumber(), librarian.getEmail(),librarian.getId());
	}

	@Override
	public Librarian librarian(String email, String password) {
		Librarian librarian = null;
		try {
			librarian = template.queryForObject("select * from lbrns where email=? and password=?", librarianMapper, email, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return librarian;
	}

	@Override
	public void addBook(Book book) {
		template.update("insert into libbooks (name,col,author,publisher,description,quantity) values (?,?,?,?,?,?)", 
				book.getName(),book.getColumn(),book.getAuthor(),book.getPublisher(),book.getDescription(),book.getQuantity());
		
	}

}

package com.mars.elibrary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.elibrary.entity.Book;
import com.mars.elibrary.entity.Borrower;
import com.mars.elibrary.entity.Librarian;
@Component
public class LibDaoImp implements LibDao {
	
	@Autowired
	private RowMapper<Borrower> borrowerMapper;

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private RowMapper<Book> bookMapper;
	
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

	@Override
	public List<Book> getBooks() {
		List<Book> books = template.query("select * from libbooks", bookMapper);
		return books;
		
	}

	@Override
	public Book getBook(int book_id) {
		Book book = template.queryForObject("select * from libbooks where id = ?", bookMapper, book_id);
		return book;
	}

	@Override
	public void issueBook(Borrower borrower) {
		template.update("insert into borrowers (name, mobile, date, book_id, book_name) values (?,?,?,?,?)",
				borrower.getName(),borrower.getMobile(),borrower.getDate(),borrower.getBook_id(),borrower.getBook_name());
		int issued = this.getBook(borrower.getBook_id()).getIssued();
		issued++;
		template.update("update libbooks set issued = ? where id = ?", issued, borrower.getBook_id());
	}

	@Override
	public List<Borrower> getBorrowers() {
		List<Borrower> borrowers = template.query("select * from borrowers", borrowerMapper);
		return borrowers;
	}

	@Override
	public int returnBook(Borrower borrower) {
		int update = template.update("delete from borrowers where book_id = ? and name = ? and mobile = ?", 
				borrower.getBook_id(), borrower.getName(),borrower.getMobile());
		if (update != 0) {
			int issued = this.getBook(borrower.getBook_id()).getIssued();
			template.update("update libbooks set issued = ? where id = ?", --issued, borrower.getBook_id());
		}
		return update;
	}

}

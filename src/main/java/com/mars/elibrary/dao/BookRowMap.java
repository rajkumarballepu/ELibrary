package com.mars.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.elibrary.entity.Book;

@Component
public class BookRowMap implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setName(rs.getString("name"));
		book.setColumn(rs.getString("col"));;
		book.setAuthor(rs.getString("author"));
		book.setPublisher(rs.getString("publisher"));
		book.setQuantity(rs.getInt("quantity"));
		book.setDescription(rs.getString("description"));
		book.setIssued(rs.getInt("issued"));
		
		return book;
	}

}

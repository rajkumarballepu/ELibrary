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
		book.setName(rs.getString("bname"));
		book.setColumn(rs.getString("column"));;
		book.setAuthor(rs.getString("author"));
		book.setPublisher(rs.getString("publisher"));
		book.setQuantity(rs.getInt("quantity"));
		book.setDescription(rs.getString("description"));
		
		return book;
	}

}

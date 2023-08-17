package com.mars.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.elibrary.entity.Borrower;

@Component
public class BorrowerMap implements RowMapper<Borrower> {

	@Override
	public Borrower mapRow(ResultSet rs, int arg1) throws SQLException {
		Borrower borrower = new Borrower();
		borrower.setId(rs.getInt("id"));
		borrower.setName(rs.getString("name"));
		borrower.setMobile(rs.getString("mobile"));
		borrower.setDate(rs.getString("date"));
		borrower.setBook_id(rs.getInt("book_id"));
		borrower.setBook_name(rs.getString("book_name"));
		return borrower;
	}

}

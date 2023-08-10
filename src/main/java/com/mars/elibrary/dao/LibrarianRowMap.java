package com.mars.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.elibrary.entity.Librarian;
@Component
public class LibrarianRowMap implements RowMapper<Librarian> {

	@Override
	public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Librarian librarian = new Librarian();
		librarian.setId(rs.getInt("id"));
		librarian.setName(rs.getString("name"));
		librarian.setNumber(rs.getString("mobile"));
		librarian.setEmail(rs.getString("email"));
		librarian.setPassword(rs.getString("password"));
		return librarian;
	}


}

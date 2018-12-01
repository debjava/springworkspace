package com.ddlab.rnd.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<Person> {
	
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		return person;
	}
}
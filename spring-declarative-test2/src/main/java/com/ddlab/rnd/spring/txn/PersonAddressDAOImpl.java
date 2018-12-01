package com.ddlab.rnd.spring.txn;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonAddressDAOImpl implements IPersonAddressDAO {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createPerson(Person person) {
		String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";

		Object[] params = new Object[] {person.getFirstName(), person.getLastName() };

		jdbcTemplate.update(insertQuery, params);
		
		System.out.println("Person saved successfully");
		
	}

	public void createAddress(Address adrs) {
		
		String insertQuery = "insert into address (city) values(?)";

		Object[] params = new Object[] {adrs.getCity() };

		jdbcTemplate.update(insertQuery, params);
		
		System.out.println("Address saved successfully");
		
	}

}

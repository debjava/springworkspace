package com.ddlab.rnd.spring.txn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Repository 
@Transactional
public class TempDAOImpl {//implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void addPerson(Person person) {

		String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";

		Object[] params = new Object[] {person.getFirstName(), person.getLastName() };

		jdbcTemplate.update(insertQuery, params);
		
		System.out.println("Transaction saved successfully");
//		throw new NullPointerException("Some unwanted exception ....");
//		throw new RuntimeException("Some unwanted exception ....");

	}

//	@Transactional(propagation = Propagation.REQUIRES_NEW , rollbackFor=RuntimeException.class)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updatePerson(Person person) {

		String queryString = "UPDATE person SET FIRSTNAME = ? WHERE id = ?";  

		Object[] params = new Object[] {person.getFirstName(), person.getId() };

		try {
			jdbcTemplate.update(queryString, params);
			String s = null;
			if( s == null )
			throw new NullPointerException("Exception ..........");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
//		throw new RuntimeException("Some unwanted exception ....");

	}

	public void deletePerson(Person person) {

		String queryString = "DELETE from person WHERE id = ?";  

		Object[] params = new Object[] {person.getId() };

		jdbcTemplate.update(queryString, params);

	}

	public List<Person> getAllPersons() {
		List<Person> personList = null;
		try {
			String queryString = "select * from person";  

			personList = jdbcTemplate.query(queryString, new PersonMapper() );

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personList;
	}

	public Person getPersonById(int id) {

		String queryString = "select * from person where id = ?";  
		Object[] params = new Object[]{id};
		Person p = jdbcTemplate.queryForObject(queryString, params , new PersonMapper() );

		return p;
	}

	//RowMapper implementation
	private class PersonMapper implements RowMapper {

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person p = new Person();
			p.setId(rs.getInt("ID"));
			p.setFirstName(rs.getString("FIRSTNAME"));
			p.setLastName(rs.getString("LASTNAME"));
			return p;
		}



	}

}

package com.ddlab.rnd.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersonDAOImpl implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addPerson(Person person) {

		try {
			String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";

			Object[] params = new Object[] {person.getFirstName(), person.getLastName() };

			jdbcTemplate.update(insertQuery, params);

			//Since it is not a transaction, it will store the data.
			//Then it will throw exception
			throw new NullPointerException("Some unwanted exception ...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePerson(Person person) {

		try {
			String queryString = "UPDATE person SET FIRSTNAME = ? WHERE id = ?";  

			Object[] params = new Object[] {person.getFirstName(), person.getId() };

			jdbcTemplate.update(queryString, params);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletePerson(Person person) {

		try {
			String queryString = "DELETE from person WHERE id = ?";  

			Object[] params = new Object[] {person.getId() };

			jdbcTemplate.update(queryString, params);


		} catch (Exception e) {
			e.printStackTrace();
		}

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

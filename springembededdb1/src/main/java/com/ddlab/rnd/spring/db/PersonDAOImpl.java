package com.ddlab.rnd.spring.db;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO {

	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public List<Person> getAllPersons() {
		String sqlQuery = "select * from Person";
		List<Person> persons = jdbcTemplate.query(sqlQuery, new PersonMapper());
		return persons;
	}

	public Person getPersonById(int id) {
		String sqlQuery = "select * from Person where id = ?";
		Person person = jdbcTemplate.queryForObject(sqlQuery,
				new Object[] { id }, new PersonMapper());
		return person;
	}

	public void createPerson(Person person) {

		String sqlQuery = "insert into Person values (?,?)";
		jdbcTemplate.update(sqlQuery,
				new Object[] { person.getId(), person.getName() });
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

}

package com.ddlab.rnd.spring.txn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.support.TransactionTemplate;

public class PersonDAOImpl implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	private TransactionTemplate txnTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTxnTemplate(TransactionTemplate txnTemplate) {
		this.txnTemplate = txnTemplate;
	}


	public void addPerson(Person person) {

		String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";

		Object[] params = new Object[] {person.getFirstName(), person.getLastName() };

		NoResultTransactionCallbackImpl txnCallbackImpl = new NoResultTransactionCallbackImpl(insertQuery, params, jdbcTemplate);

		txnTemplate.execute(txnCallbackImpl);
	}

	public void updatePerson(Person person) {

		String queryString = "UPDATE person SET FIRSTNAME = ? WHERE id = ?";  

		Object[] params = new Object[] {person.getFirstName(), person.getId() };

		NoResultTransactionCallbackImpl txnCallbackImpl = new NoResultTransactionCallbackImpl(queryString, params, jdbcTemplate);

		txnTemplate.execute(txnCallbackImpl);


	}

	public void deletePerson(Person person) {

		String queryString = "DELETE from person WHERE id = ?";  

		Object[] params = new Object[] {person.getId() };

		NoResultTransactionCallbackImpl txnCallbackImpl = new NoResultTransactionCallbackImpl(queryString, params, jdbcTemplate);

		txnTemplate.execute(txnCallbackImpl);

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
		WithResultTransactionCallbackImpl resultTxnCallback = new WithResultTransactionCallbackImpl(queryString, params, jdbcTemplate);
		
		return txnTemplate.execute(resultTxnCallback);
		
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

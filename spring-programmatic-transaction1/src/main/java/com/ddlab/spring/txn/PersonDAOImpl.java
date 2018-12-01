package com.ddlab.spring.txn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class PersonDAOImpl implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	private PlatformTransactionManager txnManager;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTxnManager(PlatformTransactionManager txnManager) {
		this.txnManager = txnManager;
	}

	public void addPerson(Person person) {
		
		DefaultTransactionDefinition txnDefn = new DefaultTransactionDefinition();
		
		//You can set propagation behaviour like this
//		txnDefn.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
		
		TransactionStatus status = txnManager.getTransaction(txnDefn);
		
		try {
			String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";
			
			Object[] params = new Object[] {person.getFirstName(), person.getLastName() };
			
			jdbcTemplate.update(insertQuery, params);
			
			txnManager.commit(status);
			
		} catch (Exception e) {
			txnManager.rollback(status);
		}
	}

	public void updatePerson(Person person) {

		TransactionDefinition txnDefn = new DefaultTransactionDefinition();
		TransactionStatus status = txnManager.getTransaction(txnDefn);
		
		try {
			String queryString = "UPDATE person SET FIRSTNAME = ? WHERE id = ?";  
			
			Object[] params = new Object[] {person.getFirstName(), person.getId() };
			
			jdbcTemplate.update(queryString, params);
			
			txnManager.commit(status);
			
		} catch (Exception e) {
			txnManager.rollback(status);
		}
		
	}

	public void deletePerson(Person person) {
		
		TransactionDefinition txnDefn = new DefaultTransactionDefinition();
		TransactionStatus status = txnManager.getTransaction(txnDefn);
		
		try {
			String queryString = "DELETE from person WHERE id = ?";  
			
			Object[] params = new Object[] {person.getId() };
			
			jdbcTemplate.update(queryString, params);
			
			txnManager.commit(status);
			
		} catch (Exception e) {
			txnManager.rollback(status);
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

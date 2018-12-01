/**
 * 
 */
package com.ddlab.rnd.spring.txn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ddlab.rnd.entities.Person;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
@Transactional
public class PersonDAOImpl implements PersonDAO {

	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.txn.CoreTransactionDAO#create(com.ddlab.rnd.entities.Person)
	 */
//	@Transactional(noRollbackFor=RuntimeException.class)
//	@Transactional(rollbackFor=RuntimeException.class)
//	@Transactional(propagation = Propagation.MANDATORY)
//	@Transactional(rollbackFor=Exception.class,propagation = Propagation.NESTED)
//	@Transactional(propagation = Propagation.NESTED)
//	@Transactional
	@Transactional(noRollbackFor=RuntimeException.class,propagation = Propagation.REQUIRES_NEW)
	public void create(Person person) {
		
		create1(person);
		
		System.out.println("------------coming here ---------------");
		
		String inserQuery = "insert into person values (?, ?, ?) ";
		Object[] params = new Object[] { person.getId(),
				person.getFirstName(), person.getLastName(), };
		int number = jdbcTemplate.update(inserQuery, params);
		throw new NullPointerException("Abra ka dabra...");
		
		
//		try {
//			String inserQuery = "insert into person values (?, ?, ?) ";
//			Object[] params = new Object[] { person.getId(),
//					person.getFirstName(), person.getLastName(), };
//			int number = jdbcTemplate.update(inserQuery, params);
//			throw new NullPointerException("Abra ka dabra...");
////			create1(person);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
//	@Transactional(propagation = Propagation.MANDATORY,rollbackFor=NullPointerException.class)
//	@Transactional(propagation = Propagation.SUPPORTS)
//	@Transactional(propagation = Propagation.NEVER)
	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.SUPPORTS)
	private void create1(Person person) {
		boolean flag = TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println(flag);
		String inserQuery = "insert into person1 values (?, ?, ?) ";
		Object[] params = new Object[] { person.getId(),
				person.getFirstName(), person.getLastName(), };
		int number = jdbcTemplate.update(inserQuery, params);
		
		throw new NullPointerException("Abra ka dabra...");
		
//		try {
//			String inserQuery = "insert into person1 values (?, ?, ?) ";
//			Object[] params = new Object[] { person.getId(),
//					person.getFirstName(), person.getLastName(), };
//			int number = jdbcTemplate.update(inserQuery, params);
//			throw new NullPointerException("Abra ka dabra...");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.txn.CoreTransactionDAO#update(com.ddlab.rnd.entities.Person)
	 */
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.txn.CoreTransactionDAO#delete(com.ddlab.rnd.entities.Person)
	 */
	public void delete(Person person) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.txn.CoreTransactionDAO#getPersonById(int)
	 */
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

/**
 * 
 */
package com.ddlab.rnd.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class SomeDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.REQUIRES_NEW) // Working fine
	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.REQUIRED) // Working fine
//	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.MANDATORY)
	// The above will throw , org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
//	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.SUPPORTS) // Not Working
	public void create1(Person person) {
		System.out.println("SessionFactory ::::"+sessionFactory);
		
//		Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		String s = null;
		session.save(person);
		Employee employee = new Employee("Deb", "Technology");
		saveEmp(employee);
		
		if(s == null) throw new RuntimeException("Some Exception ...");
	}
	
	@Transactional(noRollbackFor=NullPointerException.class,propagation = Propagation.REQUIRED) // Working fine
	private void saveEmp(Employee employee) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		
		throw new NullPointerException("Some Null Exception ...");
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

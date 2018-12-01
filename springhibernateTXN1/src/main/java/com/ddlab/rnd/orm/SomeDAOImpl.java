/**
 * 
 */
package com.ddlab.rnd.orm;

import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Debadatta Mishra (Piku)
 * 
 * http://www.byteslounge.com/tutorials/spring-transaction-propagation-tutorial
 * http://www.jeerocks.com/2012/11/spring-transaction-propagation-required.html
 * http://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation
 *
 */
public class SomeDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(rollbackFor=RuntimeException.class,propagation = Propagation.REQUIRED)
	public void create1(Person person) {
		System.out.println("SessionFactory ::::"+sessionFactory);
		
//		Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		String s = null;
		session.save(person);
		Employee employee = new Employee("Deb", "Technology");
		saveEmp(employee);
		
//		if(s == null) throw new RuntimeException("Some Exception ...");
	}
	
	@Transactional(noRollbackFor=NullPointerException.class,propagation = Propagation.REQUIRES_NEW) 
	private void saveEmp(Employee employee) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		
//		throw new NullPointerException("Some Null Exception ...");
		
		try {
			throw new FileNotFoundException("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

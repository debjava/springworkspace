package com.ddlab.old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SocketUtils;

import com.ddlab.rnd.spring.txn.Person;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDAO personDAO;
	
	@Autowired @Qualifier("tempDAO")
	private TempDAOImpl tempDAO;
	
//	@Autowired
//	private AnotherService as;
	
//	@Autowired
//	private ApplicationContext applicationContext;

	@Transactional(propagation = Propagation.REQUIRED)
	public void createPerson(Person person) {
		personDAO.addPerson(person);
		update(person); //does not work
		
//		updatePerson(person);
		
//		as.noUpdate(person);//Does not work
		
//		new AnotherService().noUpdate(person); // It works
		
		
//		AnotherService as = (AnotherService) applicationContext.getBean("as");
//		as.noUpdate(person); // Does not work
		
//		tempDAO.updatePerson(person);
		
	}
	
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(Person person) {
		
		tempDAO.updatePerson(person);
		
//		try {
//			tempDAO.updatePerson(person);
//			String s = null;
//			if( s == null )
//			throw new NullPointerException("Exception ..........");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
		
		throw new NullPointerException("Exception ..........");
	}

	public void deletePerson(Person person) {
		personDAO.deletePerson(person);
		
	}

	public List<Person> getAllPersons() {
		return personDAO.getAllPersons();
	}

	public Person getPersonById(int id) {
		return personDAO.getPersonById(id);
	}
	
	

}

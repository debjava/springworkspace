package com.ddlab.rnd.spring.txn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDAO personDAO;

	@Transactional(noRollbackForClassName={"NullPointerException"})
	public void createPerson(Person person) {
		personDAO.addPerson(person);
	}

	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
		
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

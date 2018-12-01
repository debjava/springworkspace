package com.ddlab.rnd.spring.txn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDAO personDAO;

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

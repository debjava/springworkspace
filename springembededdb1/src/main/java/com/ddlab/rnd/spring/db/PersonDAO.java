package com.ddlab.rnd.spring.db;

import java.util.List;

public interface PersonDAO {
	
	public List<Person> getAllPersons();

	public Person getPersonById(int id);

	public void createPerson(Person person);
}
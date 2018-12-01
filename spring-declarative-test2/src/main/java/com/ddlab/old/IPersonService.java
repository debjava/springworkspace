package com.ddlab.old;

import java.util.List;

import com.ddlab.rnd.spring.txn.Person;

public interface IPersonService {
	
	public void createPerson( Person person );
	
	public void updatePerson( Person person );
	
	public void deletePerson( Person person );
	
	public List<Person> getAllPersons();
	
	public Person getPersonById( int id );

}

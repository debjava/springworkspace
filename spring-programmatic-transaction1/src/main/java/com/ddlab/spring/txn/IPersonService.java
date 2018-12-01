package com.ddlab.spring.txn;

import java.util.List;

public interface IPersonService {
	
	public void createPerson( Person person );
	
	public void updatePerson( Person person );
	
	public void deletePerson( Person person );
	
	public List<Person> getAllPersons();
	
	public Person getPersonById( int id );

}

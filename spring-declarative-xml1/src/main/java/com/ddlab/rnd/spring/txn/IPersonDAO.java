package com.ddlab.rnd.spring.txn;

import java.util.List;

public interface IPersonDAO {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

	public List<Person> getAllPersons();

	public Person getPersonById(int id);

}

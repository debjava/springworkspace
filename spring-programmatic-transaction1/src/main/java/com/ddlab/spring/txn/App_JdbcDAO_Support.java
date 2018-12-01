package com.ddlab.spring.txn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_JdbcDAO_Support {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		//No need to set ID as in MySQL, it is auto increment
		person.setFirstName("Arzoo");
		person.setLastName("Mishra");
		
		ApplicationContext context = null;
		try {
			
			context = new ClassPathXmlApplicationContext("spring-txn-jdbc-DAO-Support.xml");
			IPersonService personService = (IPersonService) context.getBean("personService");
			//Create a person
			personService.createPerson(person);
			
			//Update a person
//			Person updatedPerson = new Person();
//			updatedPerson.setId(2);
//			updatedPerson.setFirstName("Bibhu");
//			personService.updatePerson(updatedPerson);
//			
//			//Get all persons
//			List<Person> personList = personService.getAllPersons();
//			for( Person p : personList ) {
//				System.out.println(p.getId()+"----"+p.getFirstName()+"----"+p.getLastName());
//			}
//			
//			//Get person by Id
//			Person p = personService.getPersonById(3);
//			System.out.println(p.getId()+"----"+p.getFirstName()+"----"+p.getLastName());
//			System.out.println("Saved Successfully...");
//			
//			//Delete a person
//			Person deletedPerson = new Person();
//			deletedPerson.setId(1);
//			personService.deletePerson(deletedPerson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

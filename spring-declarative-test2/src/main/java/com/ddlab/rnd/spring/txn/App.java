package com.ddlab.rnd.spring.txn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setFirstName("A15");
		person.setLastName("PIST");
		
		
		Address adrs = new Address();
		adrs.setCity("Bangalore");
		
		ApplicationContext context = null;
		try {
			
			context = new ClassPathXmlApplicationContext("spring-txn.xml");
			IPersonAddressService personAddressService = (IPersonAddressService) context.getBean("personAddressService");
			//Create a person
			personAddressService.createPersonAddress(person, adrs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

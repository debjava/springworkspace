package com.ddlab.rnd.spring.txn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setFirstName("Piku");
		person.setLastName("Mishra");
		
		ShoppingCart cart = new ShoppingCart(person.getFirstName(), 1);
		
		Product prod = new Product(person.getFirstName(), "bought");
		
		Account act = new Account(person.getFirstName(), "11111111111");
		
		
		
		ApplicationContext context = null;
		try {
			
			context = new ClassPathXmlApplicationContext("spring-txn.xml");
			IFlipkartService service = (IFlipkartService) context.getBean("flipkartService");
			service.buyProduct(person, cart, prod, act);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

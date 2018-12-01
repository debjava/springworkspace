package com.ddlab.rnd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ICard card = (ICard) context.getBean("cardBean");
		System.out.println(card.getType());
	}
}

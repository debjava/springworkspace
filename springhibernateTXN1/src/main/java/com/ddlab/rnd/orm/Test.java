/**
 * 
 */
package com.ddlab.rnd.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app-context.xml");
		SomeDAOImpl dao = (SomeDAOImpl) applicationContext.getBean("somedaoimpl");
		Person person = new Person("PQRS-3");
		dao.create1(person);

	}

}

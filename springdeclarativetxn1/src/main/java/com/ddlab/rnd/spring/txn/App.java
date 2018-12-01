package com.ddlab.rnd.spring.txn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.entities.Person;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("txnbeans.xml");
    	PersonDAO dao = (PersonDAO) applicationContext.getBean("coreTxnDAO");
    	Person person = new Person();
    	person.setId(1);
    	person.setFirstName("Deba");
    	person.setLastName("Mishra");
		dao.create(person);
//		dao.create(person);
    }
}

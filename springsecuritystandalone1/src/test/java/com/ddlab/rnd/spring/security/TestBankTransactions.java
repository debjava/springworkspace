/**
 * 
 */
package com.ddlab.rnd.spring.security;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class TestBankTransactions {
	
	private static BankTransaction bankTxn = null;
	
	@BeforeClass
	public static void setup() {
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans1.xml");
		bankTxn = (BankTransaction) applicationContext.getBean("bankTxn");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void check() {
		SecurityUtil.loginAs("Deb", "pqrs", "ROLE_ADMIN");
		bankTxn.checkAccountStatus("12345");
	}

}

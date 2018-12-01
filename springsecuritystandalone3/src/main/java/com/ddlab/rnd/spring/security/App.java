package com.ddlab.rnd.spring.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	//Anybody greater than equal to MANAGER
	public static void approveLoan(BankTransaction bankTxn) {
//		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.approveLoan("12345");
	}

	//Anybody greater than equal to CLERK can withdraw money
	public static void withDrawMoney(BankTransaction bankTxn) {
//		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.CLERK);
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.withdrawMoney("12345", 700);
	}

	public static void openAccount(BankTransaction bankTxn) {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
//		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
//		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.CLERK);
		bankTxn.openAccount("12345");
	}


    public static void main( String[] args )
    {
//    	ApplicationContext applicationContext =  new ClassPathXmlApplicationContext(new String[]{"beans1.xml","application-security.xml"});
    	ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
//    	SecurityUtil.loginAs("Deb", "pqrs", "ROLE_USER");
//    	SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
//    	SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
//    	SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
//		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
    	
    	BankTransaction bankTxn = (BankTransaction) applicationContext.getBean("bankTxn");
//    	bankTxn.approveLoan("12345");

		withDrawMoney(bankTxn);
		approveLoan(bankTxn);
		openAccount(bankTxn);





//    	bankTxn.openAccount("Deb");
//    	bankTxn.checkAccountStatus("12345");
    }
}

/**
 * Junit Test Cases
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
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
		bankTxn = (BankTransaction) applicationContext.getBean("bankTxn");
	}
	
	//For Loan Approval
	@Test(expected=AccessDeniedException.class)
	public void testApproveLoanByNormalUser() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
		bankTxn.approveLoan("12345");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testApproveLoanByAdmin() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.approveLoan("12345");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testApproveLoanByTeller() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.approveLoan("12345");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testApproveLoanAnonymously() {
		bankTxn.approveLoan("12345");
	}
	
	@Test
	public void testApproveLoanByManager() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		bankTxn.approveLoan("12345");
	}
	
	//All bank employee suggest a customer for a free credit card
	@Test
	public void testSuggestForCreditCardLoanByManager() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		bankTxn.suggestCreditCard("John Abraham");
	}
	
	@Test
	public void testSuggestForCreditCardLoanByAdmin() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.suggestCreditCard("John Abraham");
	}
	
	@Test
	public void testSuggestForCreditCardLoanByTeller() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.suggestCreditCard("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testSuggestForCreditCardLoanByUser() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
		bankTxn.suggestCreditCard("John Abraham");
	}
	
	//A user can open account but bank employees should not open in the same bank
	
	@Test
	public void testOpenAccountByUser() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
		bankTxn.openAccount("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testOpenAccountByAdmin() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.openAccount("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testOpenAccountByManager() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		bankTxn.openAccount("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testOpenAccountByTeller() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.openAccount("John Abraham");
	}
	
	//Rest user's Internet banking password
	
	@Test(expected=AccessDeniedException.class)
	public void testResetNetBankingPasswordByTeller() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.resetNetBankingPassword("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testResetNetBankingPasswordByUser() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
		bankTxn.resetNetBankingPassword("John Abraham");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testResetNetBankingPasswordByManager() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		bankTxn.resetNetBankingPassword("John Abraham");
	}
	
	@Test
	public void testResetNetBankingPasswordByAdmin() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.resetNetBankingPassword("John Abraham");
	}
	
	//Account status can be checked by Bank Manager or Teller
	
	@Test(expected=AccessDeniedException.class)
	public void testCheckAccountStatusByAdmin() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
		bankTxn.checkAccountStatus("12345");
	}
	
	@Test
	public void testCheckAccountStatusByManager() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.MANAGER);
		bankTxn.checkAccountStatus("12345");
	}
	
	@Test
	public void testCheckAccountStatusByTeller() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.TELLER);
		bankTxn.checkAccountStatus("12345");
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testCheckAccountStatusByUser() {
		SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER);
		bankTxn.checkAccountStatus("12345");
	}

}

/**
 * 
 */
package com.ddlab.rnd.spring.security;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class BankTransactionImpl implements BankTransaction {

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BankTransaction#approveLoan(java.lang.String)
	 */
	public void approveLoan(String actNo) {
		System.out.println("The loan has been approved for the account no : "+actNo);
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BankTransaction#openAccount(java.lang.String)
	 */
	public void openAccount(String customerName) {
		System.out.println("Hi "+customerName+" , your account will be activate within 24 hours");
		
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BankTransaction#resetNetBankingPassword(java.lang.String)
	 */
	public void resetNetBankingPassword(String customerName) {
		System.out.println("Hi "+customerName+", Administrator has rest your internet banking password "
				+ "and an email has been sent you");
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BankTransaction#checkAccountStatus(java.lang.String)
	 */
	public void checkAccountStatus(String actNo) {
		System.out.println("You available balance is 2000 INR");
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BankTransaction#suggestCreditCard(java.lang.String)
	 */
	public void suggestCreditCard(String customerName) {
		System.out.println("Hi "+customerName+" , a life time free Titanium credit card is available for you");
	}

}

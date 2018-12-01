package com.ddlab.rnd.spring.security;

public class BankTransactionImpl implements BankTransaction {

	public void approvePersonalLoan(String actNo) {
		System.out.println("The personal loan has been approved for the account no : "+actNo);
	}

	public void openAccount(String userName) {
		System.out.println("Hi "+userName+" , your account will be activate within 24 hours");
		
	}

	public void resetNetBankingPassword(String userName) {
		System.out.println("Hi "+userName+", Administrator has rest your internet banking password "
				+ "and an email has been sent you");
	}

	public void checkAccountStatus(String actNo) {
		System.out.println("You available balance is 2000 INR");
	}

	public void approveHouseBuildingLoan(int amount) {
		System.out.println("House building loan approved ...");
	}

	public void editAccount(String actNo , Permission permission) {
		System.out.println("Your account has been edited and modified ...");
	}

	public void disburseLoan() {
		System.out.println("Loan amount disbursed ...");
	}

	public void applyCreditCard() {
		System.out.println("you have applied for credit card ...");
	}
}

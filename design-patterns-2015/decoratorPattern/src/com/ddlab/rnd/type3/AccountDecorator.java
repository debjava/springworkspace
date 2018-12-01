package com.ddlab.rnd.type3;

public abstract class AccountDecorator implements Account {
	
	protected Account accountToBeDecorated;
	
	public AccountDecorator(Account accountToBeDecorated) {
		this.accountToBeDecorated = accountToBeDecorated;
	}

	public String getDescription() {
		return accountToBeDecorated.getDescription(); // Delegation
	}

}

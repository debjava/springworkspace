package com.ddlab.rnd.type3;

public class MultiCurrencyAccountDecorator extends AccountDecorator {
	
	public MultiCurrencyAccountDecorator(Account accountToBeDecorated) {
		super(accountToBeDecorated);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", including multi currency support";
	}

}

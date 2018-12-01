package com.ddlab.rnd.type3;

public class OverDraftFacilityAccountDecorator extends AccountDecorator {

	public OverDraftFacilityAccountDecorator(Account accountToBeDecorated) {
		super(accountToBeDecorated);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", including overdraft facility";
	}
	
}

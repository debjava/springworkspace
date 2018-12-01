package com.ddlab.rnd.type3;

public class Test {

	public static void main(String[] args) {
		
		Account account = new MultiCurrencyAccountDecorator(
				new OverDraftFacilityAccountDecorator(new RetailAccount()));
		//Output -> Retail account, including overdraft facility, including multi currency support
		
//		Account account = new MultiCurrencyAccountDecorator(new RetailAccount());
		//Output -> Retail account, including multi currency support
		
//		Account account = new OverDraftFacilityAccountDecorator(new RetailAccount());
		//Output -> Retail account, including overdraft facility
		
		System.out.println(account.getDescription());

	}

}

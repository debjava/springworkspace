package com.ddlab.rnd.spring.txn;

public interface IPersonAddressService {
	
	public void createPersonAddress( Person person , Address adrs );
	
	public void createPerson( Person  person );
	
	public void createAddress(Address adrs);

}

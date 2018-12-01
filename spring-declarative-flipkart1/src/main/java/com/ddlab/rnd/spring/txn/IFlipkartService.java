package com.ddlab.rnd.spring.txn;

public interface IFlipkartService {
	
	void buyProduct(Person p, ShoppingCart cart , Product prod , Account act);
	
	void auditLog( Person p );
	
	void addToCart( ShoppingCart cart );
	
	void buyProduct( Product p );
	
	void debitAccount( Account act );

}

package com.ddlab.rnd.spring.txn;

public interface IFlipkartDAO {

	void auditLog( Person p );

	void addToCart( ShoppingCart cart );

	void buyProduct( Product p );

	void debitAccount( Account act );


}

package com.ddlab.rnd.spring.txn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlipkartServiceImpl implements IFlipkartService {

	@Autowired
	private FlipkartDAOImpl flipkartDAO;

	@Autowired
	private FlipkartXtendedService xtendedService;

	@Transactional
	public void buyProduct(Person p, ShoppingCart cart, Product prod, Account act) {
		
		handleAuditLog(p);//It works
		
		addToCart(cart);
		buyProduct(prod);
		debitAccount(act);
	}

	private void handleAuditLog(Person p) {
		xtendedService.auditLog(p);
	}

	@Transactional
	public void auditLog(Person p) {
		flipkartDAO.auditLog(p);
	}

	@Transactional
	public void addToCart(ShoppingCart cart) {
		flipkartDAO.addToCart(cart);
	}

	@Transactional
	public void buyProduct(Product prod) {
		flipkartDAO.buyProduct(prod);
	}

	@Transactional
	public void debitAccount(Account act) {
		flipkartDAO.debitAccount(act);
		throw new NullPointerException("There is not enough money to buy");
	}

}

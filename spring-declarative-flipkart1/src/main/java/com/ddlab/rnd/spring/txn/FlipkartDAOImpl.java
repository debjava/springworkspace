package com.ddlab.rnd.spring.txn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlipkartDAOImpl implements IFlipkartDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void auditLog(Person person) {

		String insertQuery = "insert into person (FIRSTNAME,LASTNAME) values(?,?)";

		Object[] params = new Object[] {person.getFirstName(), person.getLastName() };

		jdbcTemplate.update(insertQuery, params);

		System.out.println("Person saved successfully");

	}

	public void addToCart(ShoppingCart cart) {
		String insertQuery = "insert into ShoppingCart (name,noOfItems) values(?,?)";

		Object[] params = new Object[] {cart.getName(), cart.getNoOfItems() };

		jdbcTemplate.update(insertQuery, params);

	}

	public void buyProduct(Product p) {

		String insertQuery = "insert into Product (name,status) values(?,?)";

		Object[] params = new Object[] {p.getName(), p.getStatus() };

		jdbcTemplate.update(insertQuery, params);

	}

	public void debitAccount(Account act) {

		String insertQuery = "insert into Account (name,actNo) values(?,?)";

		Object[] params = new Object[] {act.getName(), act.getActNo() };

		jdbcTemplate.update(insertQuery, params);

	}

}

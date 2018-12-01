package com.ddlab.rnd.spring.txn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

public class NoResultTransactionCallbackImpl extends TransactionCallbackWithoutResult  {
	
	private String queryString;
	private Object[] params;
	private JdbcTemplate jdbcTemplate;
	
	public NoResultTransactionCallbackImpl( String queryString ,Object[] params , JdbcTemplate jdbcTemplate ) {
		
		this.queryString = queryString;
		this.params = params;
		this.jdbcTemplate = jdbcTemplate;
		
	}

	@Override
	protected void doInTransactionWithoutResult(TransactionStatus txnStatus) {
		try {
			jdbcTemplate.update(queryString, params);
//			throw new NullPointerException("Some unwanted exception");
		} catch (Exception e) {
			txnStatus.setRollbackOnly();
		}
	}

}

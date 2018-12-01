package com.ddlab.rnd.spring.txn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class AnotherServiceImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createAddress(Address adrs) {
		String insertQuery = "insert into address (city) values(?)";
		Object[] params = new Object[] {adrs.getCity() };
		
		jdbcTemplate.update(insertQuery, params);
		System.out.println("Address saved successfully");
		throw new RuntimeException("Unwanted exception ...");
		
	}

}

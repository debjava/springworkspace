package com.ddlab.rnd.spring.txn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class FlipkartXtendedService {

	@Autowired
	private FlipkartDAOImpl flipkartDAO;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void auditLog(Person p) {
		flipkartDAO.auditLog(p);
	}

}

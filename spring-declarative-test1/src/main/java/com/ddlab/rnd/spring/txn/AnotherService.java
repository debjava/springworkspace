package com.ddlab.rnd.spring.txn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AnotherService {
	
	@Autowired @Qualifier("tempDAO")
	private TempDAOImpl tempDAO;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	@Transactional // it also works
	public void noUpdate(Person person) {
		tempDAO.updatePerson(person);
		throw new NullPointerException("My Exception ..........");
	}


}

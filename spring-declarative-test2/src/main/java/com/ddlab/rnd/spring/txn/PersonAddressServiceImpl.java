package com.ddlab.rnd.spring.txn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Aspect
//@Transactional(propagation = Propagation.REQUIRED)

public class PersonAddressServiceImpl implements IPersonAddressService {

	@Autowired
	private IPersonAddressDAO personAdrsDAO;
	
	@Autowired
	AnotherServiceImpl anotherService;

	@Autowired
	ApplicationContext context;

	private IPersonAddressService getSpringProxy() {
		return context.getBean(this.getClass());   
	}


	@Transactional
	public void createPersonAddress(Person person, Address adrs) {
		createPerson(person);
		
		try {
			updateAddress(adrs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateAddress(Address adrs) {
//		AnotherServiceImpl anotherService = (AnotherServiceImpl) context.getBean("anotherService"); 
		anotherService.createAddress(adrs);
	}

	@Transactional
	public void createPerson(Person person) {
		personAdrsDAO.createPerson(person);
	}

//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Transactional
	public void createAddress(Address adrs) {

		personAdrsDAO.createAddress(adrs);
		throw new RuntimeException("Unwanted exception ...");

		//		try {
		//			personAdrsDAO.createAddress(adrs);
		//			throw new RuntimeException("Unwanted exception ...");
		//		} catch (Exception e) {
		//			System.out.println(e.getMessage());
		//		}

	}



}

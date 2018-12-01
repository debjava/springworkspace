package com.ddlab.rnd.nested.objects;

import com.ddlab.rnd.spring.Person;

public class Employee extends Person {
	private Address adrs;

	public Address getAdrs() {
		return adrs;
	}

	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}
}

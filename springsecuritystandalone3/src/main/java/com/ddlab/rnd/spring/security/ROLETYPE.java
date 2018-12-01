/**
 * 
 */
package com.ddlab.rnd.spring.security;

public enum ROLETYPE {
	
	USER("USER") , ADMIN("ADMIN") , MANAGER("MANAGER") , TELLER("TELLER") , CLERK("CLERK");
	
	private String role;
	
	private ROLETYPE(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return role;
	}

}

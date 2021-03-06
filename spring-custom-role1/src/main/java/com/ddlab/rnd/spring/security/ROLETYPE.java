package com.ddlab.rnd.spring.security;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public enum ROLETYPE {
	
	USER("USER") , ADMIN("ROLE_ADMIN") , MANAGER("ROLE_MANAGER") , TELLER("ROLE_TELLER");

//	USER("USER") , ADMIN("ADMIN") , MANAGER("MANAGER") , TELLER("TELLER");
	
	private String role;
	
	private ROLETYPE(String role) {
		this.role = role;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return role;
	}

}

/**
 * 
 */
package com.ddlab.rnd.spring.security;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public enum ROLETYPE {
	
	USER_ABOVE_18("ROLE_ABOVE_18") , ADMIN("ROLE_ADMIN") , USER_BELOW_18("ROLE_BELOW_18") ;
	
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

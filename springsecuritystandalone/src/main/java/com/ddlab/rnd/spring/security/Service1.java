/**
 * 
 */
package com.ddlab.rnd.spring.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class Service1 {
	
	@Secured("ROLE_USER")
	public void executeMethod1() {
		System.out.println("It will be executed only by user ....");
	}
	
	@Secured("ROLE_ADMIN")
	public void executeMethod2() {
		System.out.println("It will be executed only by Admin ....");
	}
	
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public void executeMethod3() {
		System.out.println("It should be executed only by Admin ....");
	}

}

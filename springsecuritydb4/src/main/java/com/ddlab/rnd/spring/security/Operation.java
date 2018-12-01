/**
 * 
 */
package com.ddlab.rnd.spring.security;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public interface Operation {
	
//	@PreAuthorize ("hasRole('APP_ADMIN')")
//	@Secured({"APP_WH_USER"})
//	@Secured({"APP_USER"})
//	@PreAuthorize ("hasRole('APP_ADMIN')")
	//This method can only be executed by USER only
//	@Secured({"APP_USER"})
//	@Secured({"APP_ADMIN"})
	@PreAuthorize ("hasRole('APP_ADMIN')")
	public void execute();

}

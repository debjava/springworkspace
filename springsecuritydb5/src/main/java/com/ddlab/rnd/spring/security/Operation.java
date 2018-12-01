/**
 * 
 */
package com.ddlab.rnd.spring.security;

import org.springframework.security.access.prepost.PreAuthorize;

public interface Operation {
//	@Secured({"APP_ADMIN"}) ~~ @Secured annotation does not work with custom role
	@PreAuthorize ("hasRole('APP_ADMIN')")
	public void execute();

}

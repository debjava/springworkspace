package com.ddlab.rnd.spring.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BankTransaction {
	
	/**
	 * Can be done by Manager and Admin
	 */
	@PreAuthorize ("hasRole('APP_MANAGER')")
	public void approveLoan(String actNo);
	
	/**
	 * Can be done only by USER
	 */
//	@Secured("USER") ~~ @Secured annotation does not work with Custom Role and Role Prefix
	@PreAuthorize ("hasRole('APP_USER')")
	public void openAccount(String customerName);
	
	/**
	 * Can be done by Manager and Admin
	 */
	@PreAuthorize ("hasRole('APP_MANAGER')")
	public void resetNetBankingPassword(String customerName);

	/**
	 * Can be done by Teller,Manager and Admin
	 */
	@PreAuthorize ("hasRole('APP_TELLER')")
	public void checkAccountStatus(String actNo);

	/**
	 * Can be done by anybody in bank other than Normal user or customer
	 */
	@Secured({"APP_ADMIN", "APP_MANAGER" , "APP_TELLER"})
	public void suggestCreditCard(String customerName);

	/**
	 * Can be approved only by Manager and not by any other persons
	 */
	@Secured({"APP_MANAGER"})
	public void approveOverDraftFacility(String customerName);

}

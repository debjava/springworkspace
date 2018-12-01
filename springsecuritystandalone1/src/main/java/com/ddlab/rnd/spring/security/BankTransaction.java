package com.ddlab.rnd.spring.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BankTransaction {
	
	@PreAuthorize ("hasRole('ROLE_MANAGER')")
	public void approvePersonalLoan(String actNo);

	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
	public void approveHouseBuildingLoan( int amount);
	
	@Secured("ROLE_USER")
	public void openAccount(String userName);
	
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public void resetNetBankingPassword(String userName);
	
	@PreAuthorize ("hasAnyRole('ROLE_MANAGER,ROLE_TELLER')")
	public void checkAccountStatus(String actNo) ;

	@PreAuthorize("#permission.message == 'write' and hasRole('ROLE_ADMIN')")
	public void editAccount(String actNo, Permission permission);

	@PreAuthorize(" hasAuthority('ADMIN') ")
	public void disburseLoan();

	@PreAuthorize("isFullyAuthenticated()")
	public void applyCreditCard();
}

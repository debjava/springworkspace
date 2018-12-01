/**
 *
 */
package com.ddlab.rnd.spring.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BankTransaction {

    //	@PreAuthorize ("hasRole('ROLE_MANAGER') and isFullyAuthenticated()")
//	@PreAuthorize ("isAuthenticated() and hasRole('ROLE_MANAGER')")
//	@PreAuthorize("!isAnonymous() and hasRole('ROLE_MANAGER')")
    @PreAuthorize("hasRole('MANAGER')")
    public void approveLoan(String actNo);

    @Secured("USER")
    public void openAccount(String customerName);

    //	@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasRole('MANAGER')")
    public void resetNetBankingPassword(String customerName);

    //	@PreAuthorize ("hasAnyRole('ROLE_MANAGER,ROLE_TELLER')")
    @PreAuthorize("hasRole('TELLER')")
    public void checkAccountStatus(String actNo);

    @Secured({"ROLE_ADMIN", "MANAGER", "TELLER"})
    public void suggestCreditCard(String customerName);

    /**
     * Can be approved only by Manager and not by any other persons
     */
    @Secured({"MANAGER"})
    public void approveOverDraftFacility(String customerName);

    @PreAuthorize("hasRole('CLERK')")
    public void withdrawMoney(String actNo, int amt);

}

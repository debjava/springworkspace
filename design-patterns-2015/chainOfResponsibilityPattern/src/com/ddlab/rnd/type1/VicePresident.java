package com.ddlab.rnd.type1;

public class VicePresident extends LoanApprover {
	
	@Override
	public void approveLoan(LoanData data) {
			System.out.println("Loan approved by VicePresident ...");
	}
}

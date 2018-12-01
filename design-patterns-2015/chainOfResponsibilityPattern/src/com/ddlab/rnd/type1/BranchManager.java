package com.ddlab.rnd.type1;

public class BranchManager extends LoanApprover {
	
	@Override
	public void approveLoan(LoanData data) {
		if( data.getAmount() > 1000 && data.getAmount() < 10000 )
			System.out.println("Loan approved by BranchManager ...");
		else
			successor.approveLoan(data);
	}
}

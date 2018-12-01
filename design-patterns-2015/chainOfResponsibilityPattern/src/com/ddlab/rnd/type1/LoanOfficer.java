package com.ddlab.rnd.type1;

public class LoanOfficer extends LoanApprover {
	
	@Override
	public void approveLoan(LoanData data) {
		if( data.getAmount() < 1000 )
			System.out.println("Loan approved by LoanOfficer ...");
		else
			successor.approveLoan(data);
	}

}

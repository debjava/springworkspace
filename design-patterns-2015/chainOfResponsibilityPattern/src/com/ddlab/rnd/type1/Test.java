package com.ddlab.rnd.type1;

public class Test {

	public static void main(String[] args) {
		
		LoanData data = new LoanData("Cultivation", 50000);
		LoanApprover loanOfficer = new LoanOfficer();
		LoanApprover manager = new BranchManager();
		LoanApprover vp = new VicePresident();
		
		//Form the chain
		loanOfficer.setSuccessor(manager);
		manager.setSuccessor(vp);
		
		loanOfficer.approveLoan(data);
	}
}

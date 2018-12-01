package com.ddlab.rnd.type1;

public abstract class LoanApprover {
	
	protected LoanApprover successor;

	public void setSuccessor(LoanApprover successor) {
		this.successor = successor;
	}
	
	public abstract void approveLoan(LoanData data);

}

package com.ddlab.rnd.type1;

public class LoanData {
	
	private String purpose;
	private int amount;
	
	public LoanData(String purpose, int amount) {
		this.purpose = purpose;
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public int getAmount() {
		return amount;
	}

}

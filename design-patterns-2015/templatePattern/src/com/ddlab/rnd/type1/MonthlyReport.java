package com.ddlab.rnd.type1;

public class MonthlyReport extends AbstractReport {

	@Override
	public void setHeader() {
		System.out.println("Header set ...");
	}

	@Override
	public void setBody() {
		System.out.println("Body set ...");
	}

	@Override
	public void setFooter() {
		System.out.println("Footer set ...");
		
	}

}

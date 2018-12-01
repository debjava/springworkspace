package com.ddlab.rnd.type1;

public class Numbers implements Expression {
	
	private int num;
	
	public Numbers( int num ) {
		this.num = num;
	}
	
	@Override
	public int calc() {
		return this.num;
	}

}

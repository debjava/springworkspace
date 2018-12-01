package com.ddlab.rnd.type1;

public class Add implements Expression {
	
	private Expression lhs;
	private Expression rhs;
	
	public Add(Expression lhs , Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public int calc() {
		return this.lhs.calc()+this.rhs.calc();
	}

}

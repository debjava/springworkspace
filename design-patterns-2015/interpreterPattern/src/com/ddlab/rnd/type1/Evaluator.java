package com.ddlab.rnd.type1;

public class Evaluator {
	
	public int evaluate( String statement ) {
		
		String[] exps = statement.split(" ");
		int leftOperand = Integer.parseInt( exps[0]);
		int rightOperand = Integer.parseInt( exps[2]);
		String operation = exps[1];
		return new Add( new Numbers(leftOperand) , new Numbers(rightOperand) ).calc();
	}

}

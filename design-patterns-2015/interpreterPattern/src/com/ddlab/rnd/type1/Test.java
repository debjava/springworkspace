package com.ddlab.rnd.type1;

public class Test {

	public static void main(String[] args) {
		
		String statement = "5 + 10";
		Evaluator evalutator = new Evaluator();
		int result = evalutator.evaluate(statement);
		System.out.println("Result :::"+result);
	}
}

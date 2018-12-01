package com.ddlab.rnd.type2;

public class Test {

	public static void main(String[] args) {
		Pizza pizza = new Pizza.Builder(12)
        .cheese(true)
        .pepperoni(true)
        .bacon(true)
        .build();

	}

}

package com.ddlab.rnd.type1;

public class Test {

	public static void main(String[] args) {
		
		Director director = new Director(new ConcreteBuilder());
		director.build();
		Product product = director.getProduct();
		System.out.println("Product Name :::"+product.getName());
	}

}

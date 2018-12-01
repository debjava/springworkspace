package com.ddlab.rnd.type1;

public class Client {

	public static void main(String[] args) {
		
		AbstractFactory absFact = FactoryMaker.getFactory("a");
		AbstractProductA prodA = absFact.createProductA();
		prodA.operation1();
	}

}

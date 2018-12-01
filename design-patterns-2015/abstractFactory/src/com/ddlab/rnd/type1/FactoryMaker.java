package com.ddlab.rnd.type1;

public class FactoryMaker {

	private static AbstractFactory absFactory = null;

	public static AbstractFactory getFactory(String choice) {
		if (choice.equals("a")) {
			absFactory = new ConcreteFactory1();
		} else {
			// return another ConcreteFactory
		}
		return absFactory;
	}
}

package com.ddlab.rnd.type1;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	AbstractProductA createProductA() {
		return new ProductA1();
	}
	//Create for another Product
}

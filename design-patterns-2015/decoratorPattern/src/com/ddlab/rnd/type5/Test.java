package com.ddlab.rnd.type5;

public class Test {

	public static void main(String[] args) {
		Component component = new ConcreteDecorator( new ConcreteComponent());
		System.out.println(component.operation());
	}

}

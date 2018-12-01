package com.ddlab.rnd.type1;

public class Test1 {

	public static void main(String[] args) {
		
		 IComponent component = new ConcreteComponent();
		 Decorator decorator = new ConcreteDecorator(component);
		 decorator.perform();
	}

}

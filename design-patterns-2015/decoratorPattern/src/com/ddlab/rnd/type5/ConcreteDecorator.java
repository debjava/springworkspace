package com.ddlab.rnd.type5;

public class ConcreteDecorator extends Decorator {

	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	@Override
	public String operation() {
		return super.operation()+" "+"something extra";
	}
}

package com.ddlab.rnd.type1;

public class ConcreteDecorator implements Decorator {
	
	private IComponent component;
	
	public ConcreteDecorator( IComponent component ) {
		this.component = component;
	}
	
	@Override
	public void perform() {
		component.perform();
		addedBehaviur();
	}

	@Override
	public void addedBehaviur() {
		System.out.println("New behaviour added ...");
		
	}
}

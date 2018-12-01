package com.ddlab.rnd.type5;

public abstract class Decorator implements Component {
	
	protected Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public String operation() {
		return component.operation();
	}

}

package com.ddlab.rnd.type2;

public class ConcreteObserver2 extends Observer {
	
	public ConcreteObserver2(Subject s) {
		subject = s;
		subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("ConcreteObserver2 got updated state : "+subject.getState());
	}

}

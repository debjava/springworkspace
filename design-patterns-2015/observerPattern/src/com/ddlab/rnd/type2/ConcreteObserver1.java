package com.ddlab.rnd.type2;

public class ConcreteObserver1 extends Observer {
	
	public ConcreteObserver1(Subject s) {
		subject = s;
		subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("ConcreteObserver1 got updated state : "+subject.getState());
	}

}

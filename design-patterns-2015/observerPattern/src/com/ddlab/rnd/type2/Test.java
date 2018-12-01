package com.ddlab.rnd.type2;

public class Test {

	public static void main(String[] args) {
		
		Subject subject = new Subject();
		
		new ConcreteObserver1(subject);
		new ConcreteObserver2(subject);
		
		subject.setState("Delhi");
		
		subject.setState("Bangalore");

	}

}

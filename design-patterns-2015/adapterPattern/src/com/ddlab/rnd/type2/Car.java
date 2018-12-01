package com.ddlab.rnd.type2;

public class Car {
	protected Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public void turnOn() {
		engine.start();
	}

	public void turnOff() {
		engine.stop();
	}

	public void speedUp() {
		engine.accelerate();
	}

	public void brake() {
		engine.decelerate();
	}

}
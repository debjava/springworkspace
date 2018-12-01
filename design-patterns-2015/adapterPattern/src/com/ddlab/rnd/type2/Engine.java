package com.ddlab.rnd.type2;

public abstract class Engine {
	protected String name;

	public Engine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void start();

	public abstract void stop();

	public abstract void accelerate();

	public abstract void decelerate();
}
package com.ddlab.rnd.type3;
//Context
public class CarContext {
	private AccelerationState accelerationState;
	private int speed = 0;

	public void setAccelerationState(AccelerationState accelerationState) {
		this.accelerationState = accelerationState;
	}

	public void accelerate() {
		speed += accelerationState.accelerate();
	}

	public int getSpeed() {
		return speed;
	}
}
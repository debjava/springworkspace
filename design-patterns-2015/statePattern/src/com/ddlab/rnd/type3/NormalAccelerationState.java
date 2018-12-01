package com.ddlab.rnd.type3;
//Concrete State
public class NormalAccelerationState implements AccelerationState {
	@Override
	public int accelerate() {
		return 5;
	}
}
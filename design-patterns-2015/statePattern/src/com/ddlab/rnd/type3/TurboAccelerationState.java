package com.ddlab.rnd.type3;
//Concrete State
public class TurboAccelerationState implements AccelerationState {
	@Override
	public int accelerate() {
		return 10;
	}
}
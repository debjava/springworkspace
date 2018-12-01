package com.ddlab.rnd.type3;

public class Driver {
	public static void main(String[] args) {
		CarContext car = new CarContext();
		AccelerationState normal = new NormalAccelerationState();
		AccelerationState turbo = new TurboAccelerationState();
		// AccelerationState nos = new NOSAccelerationState();

		car.setAccelerationState(normal);
		car.accelerate();
		System.out.println("Current speed: " + car.getSpeed());

		car.setAccelerationState(turbo);
		car.accelerate();
		System.out.println("Current speed: " + car.getSpeed());

		// car.setAccelerationState( nos );
		// car.accelerate();
		// System.out.println( "Current speed: " + car.getSpeed() );
	}
	
	//http://www.informit.com/guides/content.aspx?g=java&seqNum=576
}
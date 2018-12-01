package com.ddlab.rnd.type2;

public class TestCar {

	public static void main(String[] args) {
		
		Car car = new Car.CarBuilder(1).automaticGear(true).bulletProof(true).build();
		System.out.println(car);
	}

}

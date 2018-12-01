package com.ddlab.rnd.type3;

public class Test {

	public static void main(String[] args) {

		Aeroplane plane = new Aeroplane();

		new AirTrafficController(plane);

		plane.setTravelledCity("Delhi");
	}

}

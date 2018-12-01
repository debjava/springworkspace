package com.ddlab.rnd.type3;

public class AirTrafficController extends AbstractTrafficController {

	public AirTrafficController(Aeroplane s) {
		plane = s;
		plane.attach(this);
	}

	@Override
	public void update() {
		System.out
				.println("AirTrafficController got info that , plane has come to : "
						+ plane.getTravelledCity());
	}

}
package com.ddlab.rnd.type3;

import java.util.ArrayList;
import java.util.List;

class Aeroplane {

	private List<AbstractTrafficController> observers = new ArrayList<AbstractTrafficController>();

	private String travelledCity;

	public void attach(AbstractTrafficController o) {
		observers.add(o);
	}

	public String getTravelledCity() {
		return travelledCity;
	}

	public void setTravelledCity(String travelledCity) {
		this.travelledCity = travelledCity;
		notifyObservers();
	}

	private void notifyObservers() {

		for (AbstractTrafficController observer : observers)
			observer.update();
	}
}
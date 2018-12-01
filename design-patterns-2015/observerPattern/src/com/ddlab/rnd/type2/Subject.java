package com.ddlab.rnd.type2;

import java.util.ArrayList;
import java.util.List;

class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	private String state;

	public void attach(Observer o) {
		observers.add(o);
	}

	public String getState() {
		return state;
	}

	public void setState(String in) {
		state = in;
		notifyObservers();
	}

	private void notifyObservers() {
		
		for( Observer observer : observers )
			observer.update();
	}
}
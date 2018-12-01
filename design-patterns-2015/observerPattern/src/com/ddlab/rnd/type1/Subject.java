package com.ddlab.rnd.type1;

class Subject {
	private Observer[] observers = new Observer[9];
	private int totalObs = 0;
	private int state;

	public void attach(Observer o) {
		observers[totalObs++] = o;
	}

	public int getState() {
		return state;
	}

	public void setState(int in) {
		state = in;
		notify11();
	}

	private void notify11() {
		for (int i = 0; i < totalObs; i++) {
			observers[i].update();
		}
	}
}
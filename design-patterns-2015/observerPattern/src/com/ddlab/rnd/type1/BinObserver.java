package com.ddlab.rnd.type1;

class BinObserver extends Observer {
	public BinObserver(Subject s) {
		subj = s;
		subj.attach(this);
	} // Observers register themselves

	public void update() {
		System.out.println("BinObserver---> " + Integer.toBinaryString(subj.getState()));
	}
}
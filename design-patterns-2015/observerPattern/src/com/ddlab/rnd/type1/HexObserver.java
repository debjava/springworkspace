package com.ddlab.rnd.type1;

class HexObserver extends Observer {
	
	public HexObserver(Subject s) {
		subj = s;
		subj.attach(this);
	}

	public void update() {
		System.out.println("HexObserver---> " + Integer.toHexString(subj.getState()));
	}
} // Observers "pull" information 
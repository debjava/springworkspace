package com.ddlab.rnd.type1;

class OctObserver extends Observer {
	public OctObserver(Subject s) {
		subj = s;
		subj.attach(this);
	}

	public void update() {
		
		System.out.println(" OctObserver---> " + Integer.toOctalString(subj.getState()));
	}
} // Observers "pull" information 
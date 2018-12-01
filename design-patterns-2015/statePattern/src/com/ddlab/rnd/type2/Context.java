package com.ddlab.rnd.type2;

public class Context {
	
	private MobileState state;

	public MobileState getState() {
		return state;
	}

	public void setState(MobileState state) {
		this.state = state;
	}
	
	public void request() {
		state.display(this);
	}

}

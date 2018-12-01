package com.ddlab.rnd.type1;
public class AlertStateContext {
	private MobileAlertState currentState;

	public AlertStateContext() {
		currentState = new Vibration();
	}

	public void setState(MobileAlertState state) {
		currentState = state;
	}

	public void alert() {
		currentState.alert(this);
	}
}
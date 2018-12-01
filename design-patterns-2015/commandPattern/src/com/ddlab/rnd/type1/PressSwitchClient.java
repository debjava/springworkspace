package com.ddlab.rnd.type1;

/* The test class or client */
public class PressSwitchClient {
	public static void main(String[] args) {

		LightReceiver lamp = new LightReceiver();
		Command switchOn = new SwitchOnConcreteCommand(lamp);
		Command switchOff = new SwitchOffConcreteCommand(lamp);

		SwitchInvoker mySwitch = new SwitchInvoker();

		// Press switch on to turn on light
		mySwitch.executeCommand(switchOn);

		// Press switch on to turn on light
		mySwitch.executeCommand(switchOff);

	}
}
package com.ddlab.rnd.type2;

//Client
public class Client {
	public static void main(String[] args) {
		RemoteControlInvoker control = new RemoteControlInvoker();
		LightReceiver light = new LightReceiver();
		Command lightsOn = new LightOnConcreteCommand(light);
		Command lightsOff = new LightOffConcreteCommand(light);
		// switch on
		control.setCommand(lightsOn);
		control.pressButton();
		// switch off
		control.setCommand(lightsOff);
		control.pressButton();
	}
}
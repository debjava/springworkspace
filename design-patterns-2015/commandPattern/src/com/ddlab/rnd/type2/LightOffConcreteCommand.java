package com.ddlab.rnd.type2;

//Concrete Command
public class LightOffConcreteCommand implements Command {
	// reference to the light
	LightReceiver light;

	public LightOffConcreteCommand(LightReceiver light) {
		this.light = light;
	}

	public void execute() {
		light.switchOff();
	}
}
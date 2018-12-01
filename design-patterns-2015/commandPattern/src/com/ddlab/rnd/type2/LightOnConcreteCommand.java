package com.ddlab.rnd.type2;

//Concrete Command
public class LightOnConcreteCommand implements Command {
	// reference to the light
	LightReceiver light;

	public LightOnConcreteCommand(LightReceiver light) {
		this.light = light;
	}

	public void execute() {
		light.switchOn();
	}
}
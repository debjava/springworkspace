package com.ddlab.rnd.type1;

/** The Command for turning on the light - ConcreteCommand #1 */
public class SwitchOnConcreteCommand implements Command {
	private LightReceiver theLight;

	public SwitchOnConcreteCommand(LightReceiver light) {
		this.theLight = light;
	}

	@Override
	// Command
	public void execute() {
		theLight.turnOn();
	}
}

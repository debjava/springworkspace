package com.ddlab.rnd.type1;

/** The Command for turning off the light - ConcreteCommand #2 */
public class SwitchOffConcreteCommand implements Command {
	
	private LightReceiver theLight;

	public SwitchOffConcreteCommand(LightReceiver light) {
		this.theLight = light;
	}

	@Override
	// Command
	public void execute() {
		theLight.turnOff();
	}
}
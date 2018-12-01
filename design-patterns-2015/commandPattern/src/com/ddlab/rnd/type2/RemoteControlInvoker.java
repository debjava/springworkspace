package com.ddlab.rnd.type2;

//Invoker
public class RemoteControlInvoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}
package com.ddlab.rnd.type2;

abstract class WindowDecorator implements Window {
	protected Window windowToBeDecorated; // the Window being decorated

	public WindowDecorator(Window windowToBeDecorated) {
		this.windowToBeDecorated = windowToBeDecorated;
	}

	public String getDescription() {
		return windowToBeDecorated.getDescription(); // Delegation
	}
}
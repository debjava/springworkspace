package com.ddlab.rnd.type2;

class VerticalScrollBarDecorator extends WindowDecorator {
	public VerticalScrollBarDecorator(Window windowToBeDecorated) {
		super(windowToBeDecorated);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", including vertical scrollbars";
	}
}
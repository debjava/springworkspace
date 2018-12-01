package com.ddlab.rnd.type2;

class HorizontalScrollBarDecorator extends WindowDecorator {
	
	public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
		super(windowToBeDecorated);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", including horizontal scrollbars";
	}
}
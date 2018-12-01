package com.ddlab.rnd.type4;

public class BirthDayOrderDecorator extends OrderDecorator {
	
	public BirthDayOrderDecorator(Order orderTobeDecorated) {
		super(orderTobeDecorated);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", including birthday gift wrap";
	}
}

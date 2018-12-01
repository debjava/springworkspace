package com.ddlab.rnd.type4;

public class MarriageAniversaryOrderDecorator extends OrderDecorator {

	public MarriageAniversaryOrderDecorator(Order orderTobeDecorated) {
		super(orderTobeDecorated);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription()+" , including Happy Marriage Card";
	}
}

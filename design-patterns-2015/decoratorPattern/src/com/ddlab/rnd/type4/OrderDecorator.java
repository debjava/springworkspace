package com.ddlab.rnd.type4;

public abstract class OrderDecorator implements Order {
	
	protected Order orderTobeDecorated;
	
	public OrderDecorator( Order orderTobeDecorated) {
		this.orderTobeDecorated = orderTobeDecorated;
	}
	
	@Override
	public String getDescription() {
		return orderTobeDecorated.getDescription();
	}

}

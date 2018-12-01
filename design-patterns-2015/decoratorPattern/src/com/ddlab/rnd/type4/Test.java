package com.ddlab.rnd.type4;

public class Test {

	public static void main(String[] args) {
//		Order order = new BirthDayOrderDecorator( new MobileOrder());
		//Same day birth day and marriage day
		Order order = new BirthDayOrderDecorator( new MarriageAniversaryOrderDecorator( new MobileOrder()));
		System.out.println(order.getDescription());
	}

}

package com.ddlab.rnd.type1;

public class NokiaPlug implements Plug {

	@Override
	public void consume(int volt) {
		System.out.println("It can consume 20 volt only");
	}

}

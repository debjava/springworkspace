package com.ddlab.rnd.type1;

public class ApplePlug implements Plug {

	@Override
	public void consume(int volt) {
		System.out.println("It can consume 30 volt only");
	}

}

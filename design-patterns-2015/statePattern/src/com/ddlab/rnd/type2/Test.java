package com.ddlab.rnd.type2;

public class Test {

	public static void main(String[] args) {
		Context context = new Context();
		context.setState( new SilentState());
		context.request();
		context.setState( new VibrationState());
		context.request();
	}
}

package com.ddlab.rnd.type1;
public class Silent implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		System.out.println("silent...");
	}

}
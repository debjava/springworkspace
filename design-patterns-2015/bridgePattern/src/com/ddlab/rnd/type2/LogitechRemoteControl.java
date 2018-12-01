package com.ddlab.rnd.type2;
public class LogitechRemoteControl extends AbstractRemoteControl {
 
	public LogitechRemoteControl(ITV tv) {
		super(tv);
	}
 
	public void setChannel(int channel){
		setChannel(channel);
		System.out.println("Logitech use keyword to set channel.");
	}
}
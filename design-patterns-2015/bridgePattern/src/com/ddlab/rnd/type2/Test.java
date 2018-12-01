package com.ddlab.rnd.type2;
public class Test {
	public static void main(String[] args){
		ITV tv = new SamsungTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.setChannel(100);	
	}
}
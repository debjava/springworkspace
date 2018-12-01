package com.ddlab.rnd.type1;

public class Test {

	public static void main(String[] args) {
		Socket socket = new IndianSocket();
		Plug plug = new NokiaPlug();
		
		PlugAdapter adapter = new PlugAdapter(socket, plug);
		int volt = adapter.getOutput();
		plug.consume(volt);
	}

}

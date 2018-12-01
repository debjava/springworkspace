package com.ddlab.rnd.type1;

public class PlugAdapter {
	
	private Plug plug;
	private Socket socket;
	
	public PlugAdapter(Socket socket , Plug plug ) {
		this.plug = plug;
		this.socket = socket;
	}
	
	public int getOutput() {
		/*Complex logic*/
		
		return 15;
	}

}

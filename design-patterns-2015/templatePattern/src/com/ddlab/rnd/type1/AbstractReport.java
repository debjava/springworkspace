package com.ddlab.rnd.type1;

public abstract class AbstractReport {

	public abstract void setHeader();
	
	public abstract void setBody();
	
	public abstract void setFooter();
	
	public void generateReport() {
		setHeader();
		setBody();
		setFooter();
	}

}

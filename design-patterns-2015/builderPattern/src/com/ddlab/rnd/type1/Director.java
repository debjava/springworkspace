package com.ddlab.rnd.type1;

public class Director {
	
	IBuilder builder;
	
	public Director(IBuilder builder) {
		this.builder = builder;
	}
	
	public void build() {
		builder.buildComponent();
	}
	
	public Product getProduct() {
		return builder.getProduct();
	}

}

package com.ddlab.rnd.type1;

public class ConcreteBuilder implements IBuilder {
	
	private Product product = new Product();

	@Override
	public void buildComponent() {
		System.out.println("Built components ...");
		product.setName("Product");
	}
	
	@Override
	public Product getProduct() {
		return product;
	}

}

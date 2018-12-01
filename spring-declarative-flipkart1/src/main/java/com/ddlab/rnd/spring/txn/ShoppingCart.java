package com.ddlab.rnd.spring.txn;

public class ShoppingCart {
	
	private int id;
	private String name;
	private int noOfItems;
	
	public ShoppingCart(String name, int noOfItems) {
		super();
		this.name = name;
		this.noOfItems = noOfItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

}

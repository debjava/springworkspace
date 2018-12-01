package com.ddlab.rnd.spring.txn;

public class Product {
	
	private int id;
	private String name;
	private String status;
	
	public Product(String name, String status) {
		super();
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}
	
	

}

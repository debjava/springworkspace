package com.ddlab.rnd.spring.txn;

public class Account {
	
	private int id;
	private String name;
	private String actNo;
	
	public Account(String name, String actNo) {
		super();
		this.name = name;
		this.actNo = actNo;
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

	public String getActNo() {
		return actNo;
	}

}

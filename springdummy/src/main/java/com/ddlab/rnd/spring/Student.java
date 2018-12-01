package com.ddlab.rnd.spring;

public class Student {
	
	private String name;
	private int rollNo;
	private int marks;
	
	public Student() {
		
	}
	
	public Student(String name, int rollNo, int marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public int getMarks() {
		return marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}

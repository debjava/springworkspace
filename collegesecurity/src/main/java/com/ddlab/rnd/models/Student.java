package com.ddlab.rnd.models;

/**
 * The Class Student.
 *
 * @author Debadatta Mishra (Piku)
 */
public class Student {
	
	/** The name. */
	private String name;
	
	/** The roll no. */
	private int rollNo;
	
	/** The marks. */
	private int marks;
	
	/**
	 * Instantiates a new student.
	 */
	public Student() {
		
	}
	
	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param rollNo the roll no
	 * @param marks the marks
	 */
	public Student(String name, int rollNo, int marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the roll no.
	 *
	 * @return the roll no
	 */
	public int getRollNo() {
		return rollNo;
	}

	/**
	 * Gets the marks.
	 *
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the roll no.
	 *
	 * @param rollNo the new roll no
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Sets the marks.
	 *
	 * @param marks the new marks
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

}

package com.ddlab.rnd.handlers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ddlab.rnd.models.Student;

/**
 * The Class StudentImpl.
 *
 * @author Debadatta Mishra (Piku)
 */
public class StudentImpl implements IStudent {

	/** The students map. */
	private Map<String,Student> studentsMap = new HashMap<String,Student>();
	
	/**
	 * Instantiates a new student impl.
	 */
	public StudentImpl() {
		Student student1 = new Student("John Abraham",23,51);
		Student student2 = new Student("Vidya Balan",23,52);
		Student student3 = new Student("Kate Winslet",23,53);
		studentsMap.put("John Abraham", student1);
		studentsMap.put("Vidya Balan", student2);
		studentsMap.put("Kate Winslet", student3);
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.handlers.IStudent#getStudents()
	 */
	public Collection<Student> getStudents() {
		return studentsMap.values();
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.handlers.IStudent#getStudentByName(java.lang.String)
	 */
	public Student getStudentByName(String studentName) {
		return studentsMap.get(studentName);
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.handlers.IStudent#removeStudent(com.ddlab.rnd.models.Student)
	 */
	public void removeStudent(Student student) {
		studentsMap.remove(student.getName());
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.handlers.IStudent#modifyStudentMarks(com.ddlab.rnd.models.Student)
	 */
	public Student modifyStudentMarks(Student student) {
		studentsMap.put(student.getName(), student);
		return null;
	}

}

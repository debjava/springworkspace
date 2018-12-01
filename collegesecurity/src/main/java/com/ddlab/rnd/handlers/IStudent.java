package com.ddlab.rnd.handlers;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ddlab.rnd.models.Student;


/**
 * The Interface IStudent.
 *
 * @author Debadatta Mishra (Piku)
 */
public interface IStudent {
	
	/**
	 * Gets the students.
	 *
	 * @return the students
	 */
	@PreAuthorize ("hasRole('ROLE_USER')")
	public Collection<Student> getStudents();
	
	/**
	 * Gets the student by name.
	 *
	 * @param studentName the student name
	 * @return the student by name
	 */
	@PreAuthorize ("hasRole('ROLE_USER')")
	public Student getStudentByName(String studentName);
	
	/**
	 * Removes the student.
	 *
	 * @param student the student
	 */
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public void removeStudent(Student student);
	
	/**
	 * Modify student marks.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Student modifyStudentMarks(Student student);

}

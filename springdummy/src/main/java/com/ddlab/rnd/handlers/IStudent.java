package com.ddlab.rnd.handlers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ddlab.rnd.spring.Student;

public interface IStudent {
	
	@PreAuthorize ("hasRole('ROLE_USER')")
	public List<Student> getStudents();
	
	@PreAuthorize ("hasRole('ROLE_USER')")
	public Student getStudentByName(String studentName);
	
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public void removeStudent(Student student);
	
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Student modifyStudentMarks(Student student);

}

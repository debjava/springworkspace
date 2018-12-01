package com.ddlab.rnd.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.ddlab.rnd.spring.Student;

public class StudentImpl implements IStudent {

	private Map<String,Student> studentsMap = new HashMap<String,Student>();
	
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<Student>();
		Student student1 = new Student("John Abraham",23,55);
		Student student2 = new Student("Vidya Balan",23,55);
		Student student3 = new Student("Kate Winslet",23,55);
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentsMap.put("John Abraham", student1);
		studentsMap.put("Vidya Balan", student2);
		studentsMap.put("Kate Winslet", student3);
		return studentList;
	}

	public Student getStudentByName(String studentName) {
		return studentsMap.get(studentName);
	}

	public void removeStudent(Student student) {
		System.out.println("Trying to remove the student .....");
		
	}

	public Student modifyStudentMarks(Student student) {
		System.out.println("Trying to edit the student's marks .....");
		return null;
	}

}

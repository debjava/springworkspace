package com.ddlab.rnd.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ddlab.rnd.handlers.IStudent;

@Controller
public class DummyController {
	
	@Autowired
	private IStudent istudent;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Coming to ////////");
		List<Student> studentList = new ArrayList<Student>();
		Student student1 = new Student("John Abraham",23,55);
		Student student2 = new Student("Vidya Balan",23,55);
		Student student3 = new Student("Kate Winslet",23,55);
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		ModelAndView model = new ModelAndView();
		model.addObject("student", studentList);
		model.addObject("message", "This is a secured page");
		model.setViewName("studentsview");
		return model;
	}
	
	
	@RequestMapping(value = "/admin**", method = RequestMethod.POST)
//	public ModelAndView adminPage(@RequestParam("aaa") String s ,WebRequest webRequest) {
	public ModelAndView adminPage(@RequestParam("studentName") String studentName) {
//		System.out.println("Coming to admin page here.............");
//		System.out.println("================================");
		System.out.println(":::: S:::"+studentName);
//		System.out.println(webRequest.getParameter("aaa"));
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		Student student1 = new Student("John Abraham",23,55);
		model.addObject("student", student1);
		model.setViewName("admin");

		return model;
	}
	
	
	@RequestMapping(value = "/manageAction**", method = RequestMethod.POST)
	public ModelAndView removeStudent(@ModelAttribute("student") Student student,WebRequest webRequest) {
		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		Student student1 = new Student("John Abraham",23,55);
//		model.addObject("student", student1);
		System.out.println(webRequest.getParameter("actionName"));
		System.out.println("Name :::"+student.getName());
		System.out.println("Marks :::"+student.getMarks());
		System.out.println("RollNo :::"+student.getRollNo());
		
		istudent.removeStudent(student);
		
		model.setViewName("admin");

		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage(WebRequest webRequest,Model model1) {
//
//		System.out.println("Coming to admin page here.............");
//		System.out.println("================================");
//		System.out.println(webRequest.getParameter("aaa"));
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("admin");
//
//		return model;
//	}

}

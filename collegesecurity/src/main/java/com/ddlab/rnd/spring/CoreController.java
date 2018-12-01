package com.ddlab.rnd.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ddlab.rnd.handlers.IStudent;
import com.ddlab.rnd.models.Student;

/**
 * The Class CoreController.
 *
 * @author Debadatta Mishra (Piku)
 */
@Controller
public class CoreController {
	
	/** The istudent. */
	@Autowired
	private IStudent istudent;
	
	/**
	 * Gets the index page.
	 *
	 * @return the index page
	 */
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("home");
        return model;
        
    }
	
	/**
	 * Welcome page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/studentsview" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		Collection<Student> studentList = istudent.getStudents();
		ModelAndView model = new ModelAndView();
		model.addObject("student", studentList);
		model.addObject("message", "This is a secured page");
		model.setViewName("studentsview");
		return model;
	}
	
	/**
	 * Admin page.
	 *
	 * @param studentName the student name
	 * @return the model and view
	 */
	@RequestMapping(value = "/studentdetails**", method = RequestMethod.POST)
	public ModelAndView adminPage(@RequestParam("studentName") String studentName) {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		Student student = istudent.getStudentByName(studentName);
		model.addObject("student", student);
		model.setViewName("studentdetails");
		return model;
	}
	
	/**
	 * Removes the student.
	 *
	 * @param student the student
	 * @param webRequest the web request
	 * @return the model and view
	 */
	@RequestMapping(value = "/manageAction**", method = RequestMethod.POST)
	public ModelAndView removeStudent(@ModelAttribute("student") Student student,WebRequest webRequest) {
		ModelAndView model = new ModelAndView();
		String actionName = webRequest.getParameter("actionName");
		if(actionName.equals("modify")) {
			model.addObject("info", student.getName()+"\'s information modified successfully.");
			istudent.modifyStudentMarks(student);
		}
		else {
			model.addObject("info", student.getName()+"\' information removed successfully.");
			istudent.removeStudent(student);
		}
		model.setViewName("studentstatus");
		return model;
	}
}

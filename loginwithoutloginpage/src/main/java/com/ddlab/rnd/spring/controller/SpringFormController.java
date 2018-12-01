package com.ddlab.rnd.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class SpringFormController.
 *
 * @author Debadatta Mishra (Piku)
 */
@Controller
public class SpringFormController {

//	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
//	public ModelAndView loginPage() {
//
//		ModelAndView model = new ModelAndView();
////		model.addObject("title", "Spring Security Hello World");
////		model.addObject("message", "This is welcome page!");
//		model.setViewName("login");
//		return model;
//
//	}
	
	
	/**
 * Login page.
 *
 * @return the model and view
 */
@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}
	
	/**
	 * A1 page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/a1" }, method = RequestMethod.GET)
	public ModelAndView a1Page() {

		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is welcome page!");
		model.setViewName("a1");
		return model;

	}
	
	
	
	
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("hello");
//		return model;
//
//	}
//
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("admin");
//
//		return model;
//
//	}

}
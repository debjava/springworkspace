package com.ddlab.rnd.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public ModelAndView getHomePage() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("home");
        return model;
        
    }


}

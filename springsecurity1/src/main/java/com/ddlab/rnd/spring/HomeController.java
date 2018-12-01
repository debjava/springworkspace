package com.ddlab.rnd.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class HomeController.
 *
 * @author Debadatta Mishra (Piku)
 */
@Controller
public class HomeController {
    
    /**
     * Gets the home page.
     *
     * @return the home page
     */
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public ModelAndView getHomePage() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("home");
        return model;
        
    }


}

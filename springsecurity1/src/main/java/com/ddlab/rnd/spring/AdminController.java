package com.ddlab.rnd.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class AdminController.
 *
 * @author Debadatta Mishra (Piku)
 */
@Controller
public class AdminController {
    
    /**
     * Gets the admin page.
     *
     * @return the admin page
     */
    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public ModelAndView getAdminPage() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("admin");
        return model;
        
    }
}

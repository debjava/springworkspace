package com.ddlab.rnd.spring;

import java.util.Iterator;
import java.util.List;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Person person = new Person();
//    	person.setName("Deb");
//    	person.setAge(-29);
    	PersonValidator pv = new PersonValidator();
    	final BindException errors = new BindException(person, person.getClass().getName());
    	ValidationUtils.invokeValidator(pv, person, errors);
    	
    	if (!errors.hasErrors())
    	{
    	    // there are no validation errors
    	    System.out.println("the object is valid");
    	} 
    	else {
    		final StringBuffer errorDescription = new StringBuffer("object Person had the following validation errors\n");
    	    final List errorsList = errors.getAllErrors();
    	    Iterator errorItem = errorsList.iterator();
    	    while (errorItem.hasNext()) {
    	        final ObjectError error = (ObjectError) errorItem.next();
    	        errorDescription.append('[');
    	        errorDescription.append(error.getCode());
    	        final String defaultMessage = error.getDefaultMessage();
    	        if (StringUtils.hasText(defaultMessage)) {
    	        
    	            errorDescription.append('=');
    	            errorDescription.append(defaultMessage);
    	        }
    	        errorDescription.append(']');
    	        if (errorItem.hasNext())
    	            errorDescription.append(',');
    	    }
    	    System.out.println(errorDescription.toString());
    	    throw errors;
    	}
    }
}

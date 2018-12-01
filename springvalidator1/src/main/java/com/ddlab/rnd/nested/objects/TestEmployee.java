package com.ddlab.rnd.nested.objects;

import java.util.Iterator;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

public class TestEmployee {

	public static void main(String[] args) throws Exception {
		Employee emp = new Employee();
		EmployeeValidator pv = new EmployeeValidator(new AddressValidator());
    	final BindException errors = new BindException(emp, emp.getClass().getName());
    	ValidationUtils.invokeValidator(pv, emp, errors);
    	
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

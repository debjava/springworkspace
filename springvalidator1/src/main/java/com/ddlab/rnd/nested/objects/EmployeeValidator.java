package com.ddlab.rnd.nested.objects;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {
	
	private final AddressValidator adrsValidator;
	
	public EmployeeValidator(AddressValidator adrsValidator) {
		this.adrsValidator = adrsValidator;
	}
	
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name can not be blank");
		Employee emp = (Employee) object;
		if(emp.getAge() <= 0 )
			errors.rejectValue("age", "Age of Person can not be 0 or negative");
		 try {
	            errors.pushNestedPath("adrs");
	            ValidationUtils.invokeValidator(this.adrsValidator, emp.getAdrs(), errors);
	        } finally {
	            errors.popNestedPath();
	        }
	}
}

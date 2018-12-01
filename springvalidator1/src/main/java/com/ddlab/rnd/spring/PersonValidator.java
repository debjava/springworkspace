package com.ddlab.rnd.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name can not be blank");
		Person p = (Person) object;
		if(p.getAge() <= 0 )
			errors.rejectValue("age", "Age of Person can not be 0 or negative");
	}

}

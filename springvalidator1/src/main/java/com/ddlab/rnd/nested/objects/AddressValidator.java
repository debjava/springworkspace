package com.ddlab.rnd.nested.objects;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "cityName", "cityName can not be blank");
		ValidationUtils.rejectIfEmpty(errors, "pinCode", "pinCode can not be blank");
	}

}

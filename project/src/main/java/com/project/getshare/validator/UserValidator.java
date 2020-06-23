package com.project.getshare.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.getshare.model.User;
import com.project.getshare.services.UserService;

@Component
public class UserValidator implements Validator {

	final Integer MAX_VALUE_LENGTH = 50;
	final Integer MIN_VALUE_LENGTH = 2;
	
	@Autowired
	protected UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		String firstName = user.getFirstName().trim();
		String lastName = user.getLastName().trim();
		
		if (firstName.isEmpty()) {
			errors.rejectValue("firstName", "required");
		}
		else if (firstName.length()<MIN_VALUE_LENGTH || firstName.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("firstName", "size");
		}
		
		if (lastName.isEmpty()) {
			errors.rejectValue("lastName", "required");
		}
		else if (lastName.length()<MIN_VALUE_LENGTH || lastName.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("lastName", "size");
		}
	}

}

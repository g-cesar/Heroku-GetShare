package com.project.getshare.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.getshare.model.Credentials;
import com.project.getshare.services.CredentialsService;

@Component
public class CredentialsValidator implements Validator {

	@Autowired
	private CredentialsService cs;
	
	final Integer MAX_EMAIL_LENGTH = 30;
	final Integer MIN_EMAIL_LENGTH = 7;
	final Integer MAX_PASSWORD_LENGTH = 20;
	final Integer MIN_PASSWORD_LENGTH = 8;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Credentials.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Credentials credentials = (Credentials) target;
		String email = credentials.getEmail().trim();
		String password = credentials.getPassword().trim();
		
		if(email.isEmpty()) {
			errors.rejectValue("email", "required");
		}
		else if(email.length()<MIN_EMAIL_LENGTH || email.length()>MAX_EMAIL_LENGTH) {
			errors.rejectValue("email", "size");
		}
		else if(this.cs.getCredentials(email) != null) {
			errors.rejectValue("email", "duplicate");
		}
		
		if(password.isEmpty()) {
			errors.rejectValue("password", "required");
		}
		else if(password.length()<MIN_PASSWORD_LENGTH || password.length()>MAX_PASSWORD_LENGTH) {
			errors.rejectValue("password", "size");
		}
		
	}

}

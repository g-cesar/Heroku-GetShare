package com.project.getshare.validator;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.getshare.model.Software;
import com.project.getshare.model.SoftwareHouse;

@Component
public class SoftwareValidator implements Validator {

	final Integer MAX_VALUE_LENGTH = 50;
	final Integer MIN_VALUE_LENGTH = 2;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Software.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Software software = (Software) target;
		String name = software.getName().trim();
		String description = software.getDescription().trim();
		LocalDate publish = software.getPublish();
		Float price = software.getPrice();
		Integer size = software.getSize();
		String version = software.getVersion();
		
		if(name.isEmpty()) {
			errors.rejectValue("name", "required");
		}
		else if(name.length()<MIN_VALUE_LENGTH || name.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("name", "size");
		}
		
		if (description.isEmpty()) {
			errors.rejectValue("description", "required");
		}
		else if (description.length()<MIN_VALUE_LENGTH || description.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("description", "size");
		}
		
		if (publish == null) {
			errors.rejectValue("date", "required");
		}
		
		if (price == null) {
			errors.rejectValue("price", "required");
		}
		
		if (size == null) {
			errors.rejectValue("size", "required");
		}
		
		if (version == null) {
			errors.rejectValue("version", "required");
		}
	}

	
	
}

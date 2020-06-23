package com.project.getshare.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.getshare.model.SoftwareHouse;

@Component
public class SoftwareHouseValidator implements Validator{

	final Integer MAX_VALUE_LENGTH = 50;
	final Integer MIN_VALUE_LENGTH = 2;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return SoftwareHouse.class.equals(aClass);
	}
	
	@Override
	public void validate(Object o, Errors errors) {
		SoftwareHouse softwarehouse = (SoftwareHouse) o;
		String name = softwarehouse.getName().trim();
		String description = softwarehouse.getDescription().trim();

		if (name.isEmpty()) {
			errors.rejectValue("name", "required");
		}
		else if (name.length()<MIN_VALUE_LENGTH || name.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("name", "size");
		}
		
		if (description.isEmpty()) {
			errors.rejectValue("description", "required");
		}
		else if (description.length()<MIN_VALUE_LENGTH || description.length()>MAX_VALUE_LENGTH) {
			errors.rejectValue("description", "size");
		}

	}
	
}

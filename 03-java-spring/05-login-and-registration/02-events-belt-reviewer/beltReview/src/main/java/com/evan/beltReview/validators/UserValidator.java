package com.evan.beltReview.validators;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.evan.beltReview.models.User;
import com.evan.beltReview.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserRepository uRepo;


	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match!");
		}
		
		if(uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "This email is already taken!");
		}
	}
	
}

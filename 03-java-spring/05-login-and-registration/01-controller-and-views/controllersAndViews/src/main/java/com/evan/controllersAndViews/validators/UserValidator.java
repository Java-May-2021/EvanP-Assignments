package com.evan.controllersAndViews.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.evan.controllersAndViews.models.User;
import com.evan.controllersAndViews.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserRepository uRepo;
    

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {

            errors.rejectValue("passwordConfirmation", "Match", "Passwords do not match");
        }
        if(uRepo.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique", "Email already exsists!");
        }
    }
}
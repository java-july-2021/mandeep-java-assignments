package com.mandeep.sportsteam.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.mandeep.sportsteam.models.User;
import com.mandeep.sportsteam.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean Supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
	
		if(!user.getPassword().equals(user.getConformPassword())) {
			errors.rejectValue("password", "Match", "Password do not match!!!!!!!!!!!!!!!");
		}
		
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Sorry.... That email has already been registered. Try a different one Now");
		}
		
		
	}
	
}

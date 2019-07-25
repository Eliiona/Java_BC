package com.codeassist.CodeAssist.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Service.UserService;


/*
 * Validates if all fields are correct while creating an account
 */
@Component
public class UserValidator implements Validator{
	   @Autowired
	    private UserService userService;

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return User.class.equals(aClass);
	    }

	    @Override
	    public void validate(Object o, Errors errors) {
	        User user = (User) o;
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
	        if (user.getName().length() < 2 || user.getName().length() > 32) {
	            errors.rejectValue("name", "Size.userForm.name");
	        }
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");
	        if (user.getSurname().length() < 2 || user.getSurname().length() > 32) {
	            errors.rejectValue("surname", "Size.userForm.name");
	        }
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (user.getUsername().length() < 4 || user.getUsername().length() > 8) {
	            errors.rejectValue("username", "Size.userForm.username");
	        }
	        if (userService.findByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.userForm.username");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }
	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }
	    }
}

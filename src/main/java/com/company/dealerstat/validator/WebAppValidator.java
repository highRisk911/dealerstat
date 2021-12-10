package com.company.dealerstat.validator;

import com.company.dealerstat.entity.user.User;
import com.company.dealerstat.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class WebAppValidator implements Validator {


    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (object instanceof User) {
            User user = (User) object;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
            List<User> users = userService.findAllUsers();
            for (User u : users) {
                if (u.getEmail().equals(user.getEmail())) {
                    errors.rejectValue("email", "Duplicate.user.mail");
                }
            }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
            if (!user.getConfirmPassword().equals(user.getPassword())) {
                errors.rejectValue("password", "Different.user.password");
            }
        }
    }
}
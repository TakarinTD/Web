package com.example.easynotes.validator;

import static com.example.easynotes.constant.SystemConstant.ACTIVE_STATUS;
import com.example.easynotes.model.*;
import com.example.easynotes.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;

@Component
public class UserValidator implements Validator {
    @Autowired (required = true)
    private UserService userService;

    @Override
    public boolean supports (Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }
        if (userService.findOneByUserNameAndStatus(user.getUserName(), ACTIVE_STATUS) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (! user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}

package org.fytyny.account.forms.validators;

import org.fytyny.account.forms.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserDto userDto = (UserDto) value;
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }

}

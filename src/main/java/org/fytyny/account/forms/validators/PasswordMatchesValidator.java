package org.fytyny.account.forms.validators;

import org.fytyny.account.forms.dto.UserRegistrationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserRegistrationDto userRegistrationDto = (UserRegistrationDto) value;
        return userRegistrationDto.getPassword().equals(userRegistrationDto.getMatchingPassword());
    }

}

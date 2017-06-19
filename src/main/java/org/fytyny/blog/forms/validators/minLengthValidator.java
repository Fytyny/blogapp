package org.fytyny.blog.forms.validators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class minLengthValidator implements ConstraintValidator<LengthValidator, String> {
    private int minLength;
    @Override
    public void initialize(LengthValidator constraintAnnotation) {
        minLength = constraintAnnotation.length();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length()>=minLength;
    }
}

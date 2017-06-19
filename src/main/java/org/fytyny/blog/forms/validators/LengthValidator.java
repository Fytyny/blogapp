package org.fytyny.blog.forms.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = minLengthValidator.class)
@Documented
public @interface LengthValidator {
    int length() default 100;
    String message() default "Your input is too short. You have to write at least 100 characters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


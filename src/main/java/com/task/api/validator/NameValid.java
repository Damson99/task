package com.task.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameValid
{
    String message() default "*Illegal characters.";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

}

package io.kestra.core.validations;

import io.kestra.core.validations.validator.SwitchTaskValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SwitchTaskValidator.class)
public @interface SwitchTaskValidation {
    String message() default "invalid Switch task";
}

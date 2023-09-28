package io.kestra.core.validations;

import io.kestra.core.validations.validator.JsonStringValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = JsonStringValidator.class)
public @interface JsonString {
    String message() default "invalid json ({validatedValue})";
}
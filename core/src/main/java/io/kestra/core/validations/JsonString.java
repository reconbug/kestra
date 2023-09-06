package io.kestra.core.validations;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
public @interface JsonString {
    String message() default "invalid json ({validatedValue})";
}
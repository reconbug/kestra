package io.kestra.core.validations;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
public @interface WorkingDirectoryTaskValidation {
    String message() default "invalid WorkingDirectory task";
}

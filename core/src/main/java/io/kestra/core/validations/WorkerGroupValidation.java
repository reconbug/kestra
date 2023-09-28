package io.kestra.core.validations;

import io.kestra.core.validations.validator.WorkerGroupValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WorkerGroupValidator.class)
public @interface WorkerGroupValidation {
    String message() default "invalid workerGroup property";
}

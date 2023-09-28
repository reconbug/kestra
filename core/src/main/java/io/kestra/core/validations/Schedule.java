package io.kestra.core.validations;

import io.kestra.core.validations.validator.ScheduleValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScheduleValidator.class)
public @interface Schedule {
    String message() default "invalid schedule ({validatedValue})";
}
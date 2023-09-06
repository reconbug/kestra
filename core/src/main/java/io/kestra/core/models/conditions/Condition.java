package io.kestra.core.models.conditions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.kestra.core.exceptions.InternalException;
import io.kestra.core.utils.Rethrow;
import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.function.Predicate;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public abstract class Condition implements Rethrow.PredicateChecked<ConditionContext, InternalException> {
    @NotNull
    @Pattern(regexp="\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*(\\.\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)*")
    protected String type;
}

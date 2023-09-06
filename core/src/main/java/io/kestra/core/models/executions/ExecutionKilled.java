package io.kestra.core.models.executions;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@EqualsAndHashCode
@ToString
public class ExecutionKilled {
    @NotNull
    String executionId;
}

package io.kestra.core.models.executions;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;
import io.kestra.core.models.tasks.Task;

@Value
@AllArgsConstructor
public class NextTaskRun {
    @NotNull
    TaskRun taskRun;

    @NotNull
    Task task;
}

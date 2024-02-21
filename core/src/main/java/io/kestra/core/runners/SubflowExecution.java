package io.kestra.core.runners;

import io.kestra.core.models.executions.Execution;
import io.kestra.core.models.executions.TaskRun;
import io.kestra.core.models.tasks.Task;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class SubflowExecution {
    @NotNull
    private TaskRun parentTaskRun;

    @NotNull
    private Task parentTask;

    @NotNull
    private Execution execution;
}

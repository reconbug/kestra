package io.kestra.core.runners;

import io.kestra.core.models.executions.Execution;
import io.kestra.core.models.executions.TaskRun;
import io.kestra.core.tasks.flows.Flow;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerTaskExecution {
    @NotNull
    private TaskRun taskRun;

    @NotNull
    private Flow task;

    @NotNull
    private Execution execution;
}

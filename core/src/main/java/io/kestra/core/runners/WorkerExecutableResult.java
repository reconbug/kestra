package io.kestra.core.runners;

import io.kestra.core.models.executions.TaskRun;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
public class WorkerExecutableResult {
    @NotNull
    TaskRun taskRun;

    @NotNull
    List<SubflowExecution> subflowExecutions;

    public String uid() {
        return taskRun.getId();
    }
}

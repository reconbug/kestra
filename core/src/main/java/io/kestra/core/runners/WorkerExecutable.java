package io.kestra.core.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.kestra.core.models.Label;
import io.kestra.core.models.executions.TaskRun;
import io.kestra.core.models.flows.Flow;
import io.kestra.core.models.tasks.Task;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkerExecutable extends WorkerJob {
    public static final String TYPE = "executable";

    @NotNull
    @JsonInclude
    private final String type = TYPE;

    @NotNull
    private TaskRun taskRun;

    @NotNull
    private Task task;

    @NotNull
    private RunContext runContext;

    @NotNull
    private Flow subflow;

    @NotNull
    private Flow currentFlow;

    @NotNull
    private List<Label> executionLabels;

    @Override
    public String uid() {
        return this.taskRun.getTaskId();
    }

    @Override
    public String taskRunId() {
        return this.taskRun.getId();
    }
}

package io.kestra.core.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.kestra.core.models.Label;
import io.kestra.core.models.executions.TaskRun;
import io.kestra.core.models.flows.Flow;
import io.kestra.core.models.tasks.Task;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class WorkerExecutableRunning extends WorkerJobRunning {
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

    public static WorkerExecutableRunning of(WorkerExecutable workerExecutable, WorkerInstance workerInstance, int partitions) {
        return WorkerExecutableRunning.builder()
            .taskRun(workerExecutable.getTaskRun())
            .task(workerExecutable.getTask())
            .runContext(workerExecutable.getRunContext())
            .subflow(workerExecutable.getSubflow())
            .currentFlow(workerExecutable.getCurrentFlow())
            .executionLabels(workerExecutable.getExecutionLabels())
            .workerInstance(workerInstance)
            .partition(partitions)
            .build();
    }

    @Override
    public String uid() {
        return this.taskRun.getId();
    }
}

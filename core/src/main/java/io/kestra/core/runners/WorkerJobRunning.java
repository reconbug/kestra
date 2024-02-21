package io.kestra.core.runners;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = WorkerTaskRunning.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = WorkerTaskRunning.class, name = WorkerTaskRunning.TYPE),
    @JsonSubTypes.Type(value = WorkerExecutableRunning.class, name = WorkerExecutableRunning.TYPE),
    @JsonSubTypes.Type(value = WorkerTriggerRunning.class, name = WorkerTriggerRunning.TYPE)
})
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class WorkerJobRunning {
    @NotNull
    private WorkerInstance workerInstance;

    @NotNull
    private int partition;

    abstract public String getType();

    abstract public String uid();
}

package io.kestra.core.runners;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = WorkerTask.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = WorkerTask.class, name = WorkerTask.TYPE),
    @JsonSubTypes.Type(value = WorkerExecutable.class, name = WorkerExecutable.TYPE),
    @JsonSubTypes.Type(value = WorkerTrigger.class, name = WorkerTrigger.TYPE)
})
public abstract class WorkerJob {
    abstract public String getType();

    abstract public String uid();

    abstract public String taskRunId();
}

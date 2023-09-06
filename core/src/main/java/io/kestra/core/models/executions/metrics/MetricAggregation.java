package io.kestra.core.models.executions.metrics;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.Instant;

@Builder
public class MetricAggregation {
    @NotNull
    public String name;

    public Double value;

    @NotNull
    public Instant date;
}

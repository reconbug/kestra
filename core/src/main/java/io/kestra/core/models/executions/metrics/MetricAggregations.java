package io.kestra.core.models.executions.metrics;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class MetricAggregations {
    @NotNull
    public String groupBy;

    @NotNull
    public List<MetricAggregation> aggregations;
}

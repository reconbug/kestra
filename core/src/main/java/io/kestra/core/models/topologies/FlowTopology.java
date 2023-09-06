package io.kestra.core.models.topologies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FlowTopology {
    @NotNull
    FlowNode source;

    @NotNull
    FlowRelation relation;

    @NotNull
    FlowNode destination;

    @JsonIgnore
    public String uid() {
        // we use destination as prefix to enable prefixScan on FlowTopologyUpdateTransformer
        return destination.getUid() + "|" + source.getUid();
    }
}

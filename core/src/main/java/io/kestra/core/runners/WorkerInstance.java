package io.kestra.core.runners;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@ToString
public class WorkerInstance {
    @NotNull
    private UUID workerUuid;

    @NotNull
    private String hostname;
    private Integer port;
    private Integer managementPort;

    private String workerGroup;

    @Builder.Default
    private List<Integer> partitions = new ArrayList<>();
}

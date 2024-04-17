package io.kestra.core.runners.pebble.functions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.pebbletemplates.pebble.error.PebbleException;
import io.pebbletemplates.pebble.extension.Function;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.PebbleTemplate;
import io.kestra.core.runners.pebble.AbstractDate;

import java.util.List;
import java.util.Map;

public class JsonFunction implements Function {
    private static final ObjectMapper MAPPER = new ObjectMapper()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .registerModule(new JavaTimeModule())
        .registerModule(new Jdk8Module())
        .registerModule(new ParameterNamesModule())
        .registerModules(new GuavaModule())
        .setSerializationInclusion(JsonInclude.Include.ALWAYS);

    private static final TypeReference<Object> TYPE_REFERENCE = new TypeReference<>() {};

    public List<String> getArgumentNames() {
        return List.of("json");
    }

    @Override
    public Object execute(Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
        if (!args.containsKey("json")) {
            throw new PebbleException(null, "The 'json' function expects an argument 'json'.", lineNumber, self.getName());
        }

        if (!(args.get("json") instanceof String)) {
            throw new PebbleException(null, "The 'json' function expects an argument 'json' with type string.", lineNumber, self.getName());
        }

        String json = (String) args.get("json");;

        try {
            return MAPPER.readValue(json, TYPE_REFERENCE);
        } catch (JsonProcessingException e) {
            throw new PebbleException(null, "Invalid json: " + e.getMessage(), lineNumber, self.getName());
        }
    }
}

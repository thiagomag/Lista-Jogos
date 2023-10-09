package br.com.thiago.listajogos.config;

import br.com.thiago.listajogos.execption.ApplicationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

public class JacksonJsonParser implements JsonParser {
    private final ObjectMapper objectMapper;

    public JacksonJsonParser() {
        this.objectMapper = new ObjectMapper();
    }

    public JacksonJsonParser(ObjectMapper objectMapper) {
        Objects.requireNonNull(objectMapper);
        this.objectMapper = objectMapper;
    }

    public <T> T toObject(String json, Class<T> tar) {
        try {
            return this.objectMapper.readValue(json, tar);
        } catch (IOException var4) {
            throw new ApplicationException(var4);
        }
    }

    public String toJson(Object object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException var3) {
            throw new ApplicationException(var3);
        }
    }
}


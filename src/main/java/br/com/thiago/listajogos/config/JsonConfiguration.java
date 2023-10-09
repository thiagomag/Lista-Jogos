package br.com.thiago.listajogos.config;


import br.com.thiago.listajogos.config.deserializer.JsonR2dbcDeserializer;
import br.com.thiago.listajogos.config.deserializer.LocalDateTimeDeserializerChainResolver;
import br.com.thiago.listajogos.config.deserializer.enums.PlataformaEnumDeserializer;
import br.com.thiago.listajogos.config.deserializer.enums.TipoEnumDeserializer;
import br.com.thiago.listajogos.config.property.CommonsPropertyHolder;
import br.com.thiago.listajogos.config.serializer.EnumSerializer;
import br.com.thiago.listajogos.config.serializer.JsonR2dbcSerializer;
import br.com.thiago.listajogos.enums.PlataformaEnum;
import br.com.thiago.listajogos.enums.TipoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@RequiredArgsConstructor
public class JsonConfiguration {

    private final CommonsPropertyHolder commonsPropertyHolder;

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return create();
    }

    @Bean
    public ObjectMapper redisObjectMapper() {
        final var objectMapper = create(JsonInclude.Include.NON_NULL, PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance , ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.disable(DeserializationFeature.WRAP_EXCEPTIONS);
        return objectMapper;
    }

    @Bean
    public JsonParser jsonParser(ObjectMapper objectMapper) {
        return new JacksonJsonParser(objectMapper);
    }

    private ObjectMapper create() {
        return create(PropertyNamingStrategies.SNAKE_CASE);
    }

    private ObjectMapper create(final PropertyNamingStrategy propertyNamingStrategy) {
        return create(null, propertyNamingStrategy);
    }

    private ObjectMapper create(final JsonInclude.Include jsonInclude,
                                final PropertyNamingStrategy propertyNamingStrategy) {
        final var timeModule = new JavaTimeModule();
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializerChainResolver(commonsPropertyHolder.getDate().getDeserializer()));
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(commonsPropertyHolder.getDate().getSerializer())));

        final var builder = new Jackson2ObjectMapperBuilder();
        builder.modules(timeModule);
        builder.serializerByType(Enum.class, new EnumSerializer());
        builder.serializerByType(Json.class, new JsonR2dbcSerializer());
        builder.deserializerByType(Json.class, new JsonR2dbcDeserializer());
        builder.deserializerByType(TipoEnum.class, new TipoEnumDeserializer());
        builder.deserializerByType(PlataformaEnum.class, new PlataformaEnumDeserializer());
        if (jsonInclude != null) {
            builder.serializationInclusion(jsonInclude);
        }
        builder.failOnUnknownProperties(false);
        builder.propertyNamingStrategy(propertyNamingStrategy);
        builder.deserializers();

        final var objectMapper = builder.build();
        objectMapper.disable(DeserializationFeature.WRAP_EXCEPTIONS);

        return objectMapper;
    }

}

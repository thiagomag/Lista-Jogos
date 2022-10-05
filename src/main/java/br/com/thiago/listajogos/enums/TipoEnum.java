package br.com.thiago.listajogos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum TipoEnum {

    DIGITAL("digital"),
    FISICO("físico");

    private final String value;

    public static TipoEnum findByValue(final String value) {
        return Stream.of(values())
                .filter(v -> v.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}

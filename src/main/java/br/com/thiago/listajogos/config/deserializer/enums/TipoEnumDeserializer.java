package br.com.thiago.listajogos.config.deserializer.enums;

import br.com.thiago.listajogos.enums.TipoEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TipoEnumDeserializer extends AbstractEnumDeserializer<TipoEnum> {

    private static final String LOG_PREFIX = "[BONUS_TYPE_ENUM_DESERIALIZER]";

    @Override
    protected TipoEnum convertToEnum(String value) {
        return TipoEnum.findByValue(value);
    }

    @Override
    protected String getLogPrefix() {
        return LOG_PREFIX;
    }

}

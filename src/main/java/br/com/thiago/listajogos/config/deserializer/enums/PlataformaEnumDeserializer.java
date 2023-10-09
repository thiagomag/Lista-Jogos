package br.com.thiago.listajogos.config.deserializer.enums;

import br.com.thiago.listajogos.enums.PlataformaEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlataformaEnumDeserializer extends AbstractEnumDeserializer<PlataformaEnum> {

    private static final String LOG_PREFIX = "[BONUS_SIGNAL_CODE_ENUM_DESERIALIZER]";

    @Override
    protected PlataformaEnum convertToEnum(String value) {
        return PlataformaEnum.findByValue(value);
    }

    @Override
    protected String getLogPrefix() {
        return LOG_PREFIX;
    }

}

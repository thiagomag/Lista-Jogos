package br.com.thiago.listajogos.enums.converter;

import br.com.thiago.listajogos.enums.TipoEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class TipoEnumWritingConverter implements Converter<TipoEnum, String> {

    @Override
    public String convert(TipoEnum source) {
        return source == null ? null : source.getCode();
    }

}

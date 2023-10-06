package br.com.thiago.listajogos.enums.converter;

import br.com.thiago.listajogos.enums.TipoEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class TipoEnumReadingConverter implements Converter<String, TipoEnum> {

    @Override
    public TipoEnum convert(String source) {
        return TipoEnum.findByValue(source);
    }

}

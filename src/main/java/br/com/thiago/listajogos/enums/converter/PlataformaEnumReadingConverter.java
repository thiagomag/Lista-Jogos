package br.com.thiago.listajogos.enums.converter;

import br.com.thiago.listajogos.enums.PlataformaEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class PlataformaEnumReadingConverter implements Converter<String, PlataformaEnum> {

    @Override
    public PlataformaEnum convert(String source) {
        return PlataformaEnum.findByValue(source);
    }

}

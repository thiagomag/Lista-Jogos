package br.com.thiago.listajogos.enums.converter;

import br.com.thiago.listajogos.enums.PlataformaEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class PlataformaEnumWritingConverter implements Converter<PlataformaEnum, String> {

    @Override
    public String convert(PlataformaEnum source) {
        return source == null ? null : source.getCode();
    }

}

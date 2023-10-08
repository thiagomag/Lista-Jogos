package br.com.thiago.listajogos.adapter;

import br.com.thiago.listajogos.entity.Jogo;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class JogoResponseAdapter extends AbstractAdapter<Jogo, JogoResponse> {

    public JogoResponseAdapter(JsonUtils jsonUtils) {
        super(JogoResponse.class, jsonUtils);
    }
}

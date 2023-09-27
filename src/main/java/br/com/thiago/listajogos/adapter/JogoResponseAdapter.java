package br.com.thiago.listajogos.adapter;

import br.com.thiago.listajogos.domain.Jogo;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.utils.JsonUtils;

public class JogoResponseAdapter extends AbstractAdapter<Jogo, JogoResponse> {

    public JogoResponseAdapter(JsonUtils jsonUtils) {
        super(JogoResponse.class, jsonUtils);
    }
}

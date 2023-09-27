package br.com.thiago.listajogos.adapter;

import br.com.thiago.listajogos.domain.Jogo;
import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.utils.JsonUtils;

public class JogoAdapter extends AbstractAdapter<JogoRequest, Jogo>{

    public JogoAdapter(JsonUtils jsonUtils) {
        super(Jogo.class, jsonUtils);
    }
}

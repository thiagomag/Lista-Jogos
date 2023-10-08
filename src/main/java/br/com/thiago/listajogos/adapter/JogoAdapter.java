package br.com.thiago.listajogos.adapter;

import br.com.thiago.listajogos.entity.Jogo;
import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class JogoAdapter extends AbstractAdapter<JogoRequest, Jogo>{

    public JogoAdapter(JsonUtils jsonUtils) {
        super(Jogo.class, jsonUtils);
    }
}

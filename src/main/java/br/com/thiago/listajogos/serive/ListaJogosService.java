package br.com.thiago.listajogos.serive;

import br.com.thiago.listajogos.domain.Jogo;
import br.com.thiago.listajogos.dto.JogoDto;
import br.com.thiago.listajogos.repository.ListaJogosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ListaJogosService {

    private final ListaJogosRepository listaJogosRepository;

    public Flux<Jogo> getListaJogos() {
        return listaJogosRepository.findAll();
    }

    public Mono<Jogo> save(JogoDto jogoDto) {
        return Jogo.adpat(jogoDto)
                .flatMap(listaJogosRepository::save);
    }
}

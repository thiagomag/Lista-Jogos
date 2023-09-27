package br.com.thiago.listajogos.serive;

import br.com.thiago.listajogos.adapter.JogoAdapter;
import br.com.thiago.listajogos.adapter.JogoResponseAdapter;
import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.repository.ListaJogosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ListaJogosService {

    private final ListaJogosRepository listaJogosRepository;
    private final JogoAdapter jogoAdapter;
    private final JogoResponseAdapter jogoResponseAdapter;

    public Flux<JogoResponse> getListaJogos() {
        return listaJogosRepository.findAll()
                .map(jogoResponseAdapter::adapt);
    }

    public Mono<JogoResponse> save(JogoRequest jogoRequest) {
        return Mono.just(jogoAdapter.adapt(jogoRequest))
                .flatMap(listaJogosRepository::save)
                .map(jogoResponseAdapter::adapt);
    }
}

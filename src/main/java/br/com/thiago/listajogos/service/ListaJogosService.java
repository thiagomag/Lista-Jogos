package br.com.thiago.listajogos.service;

import br.com.thiago.listajogos.adapter.JogoAdapter;
import br.com.thiago.listajogos.adapter.JogoResponseAdapter;
import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.entity.Jogo;
import br.com.thiago.listajogos.enums.PlataformaEnum;
import br.com.thiago.listajogos.enums.TipoEnum;
import br.com.thiago.listajogos.repository.ListaJogosRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaJogosService {

    private final ListaJogosRepository listaJogosRepository;
    private final JogoAdapter jogoAdapter;
    private final JogoResponseAdapter jogoResponseAdapter;

    public Flux<JogoResponse> getListaJogos(JogoRequest searchRequest) {
        if (searchRequest == null) {
            return listaJogosRepository.findAll()
                    .map(jogoResponseAdapter::adapt);
        }
        return listaJogosRepository.findBySearchRequest(searchRequest.getNome(), searchRequest.getTipo().getCode(),
                searchRequest.getEstudio(), searchRequest.getPlataforma().getCode(), searchRequest.getUsername(),
                searchRequest.getAnoLancamento(), searchRequest.getEmailConta(), searchRequest.getNecessitaAssinatura())
                .sort(Comparator.comparing(JogoResponse::getNome));
    }

    public Mono<JogoResponse> save(JogoRequest jogoRequest) {
        return Mono.just(jogoAdapter.adapt(jogoRequest))
                .flatMap(listaJogosRepository::save)
                .map(jogoResponseAdapter::adapt);
    }

    public Mono<JogoResponse> updateJogo(JogoRequest jogoRequest, Long idJogo) {
        return listaJogosRepository.findById(idJogo)
                .map(jogo -> verificarValores(jogo, jogoRequest))
                .flatMap(listaJogosRepository::save)
                .map(jogoResponseAdapter::adapt)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Jogo com id %s não encontrado", idJogo))));
    }

    private Jogo verificarValores(Jogo jogo, JogoRequest jogoRequest) {
        return jogo.toBuilder()
                .anoLancamento(Optional.ofNullable(jogoRequest.getAnoLancamento()).orElse(jogo.getAnoLancamento()))
                .emailConta(Optional.ofNullable(jogoRequest.getEmailConta()).orElse(jogo.getEmailConta()))
                .estudio(Optional.ofNullable(jogoRequest.getEstudio()).orElse(jogo.getEstudio()))
                .urlFoto(Optional.ofNullable(jogoRequest.getUrlFoto()).orElse(jogo.getUrlFoto()))
                .nome(Optional.ofNullable(jogoRequest.getNome()).orElse(jogo.getNome()))
                .tipo(Optional.ofNullable(jogoRequest.getTipo()).orElse(jogo.getTipo()))
                .plataforma(Optional.ofNullable(jogoRequest.getPlataforma()).orElse(jogo.getPlataforma()))
                .username(Optional.ofNullable(jogoRequest.getUsername()).orElse(jogo.getUsername()))
                .necessitaAssinatura(Optional.ofNullable(jogoRequest.getNecessitaAssinatura()).orElse(jogo.getNecessitaAssinatura()))
                .build();
    }

    public Mono<JogoResponse> findJogoById(Long idJogo) {
        return listaJogosRepository.findById(idJogo)
                .map(jogoResponseAdapter::adapt)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Jogo com id %s não encontrado", idJogo))));
    }

    public Mono<Void> deletarJogo(Long idJogo) {
        return listaJogosRepository.deleteById(idJogo);
    }

    public Mono<String> processarCSV() throws IOException {
        try {
            final var reader = new CSVReader(new FileReader("jogos.csv"));
            final var listaJogos = new ArrayList<Jogo>();
            final var records = reader.readAll();
            for (String[] record : records) {
                final var jogo = Jogo.builder()
                        .id(Long.valueOf(record[0]))
                        .nome(record[1])
                        .estudio(record[2])
                        .plataforma(PlataformaEnum.valueOf(record[3]))
                        .anoLancamento(Integer.valueOf(record[4]))
                        .necessitaAssinatura(Boolean.valueOf(record[5]))
                        .tipo(TipoEnum.valueOf(record[6]))
                        .urlFoto(record[7])
                        .emailConta(record[8])
                        .username(record[9])
                        .build();
                listaJogos.add(jogo);
            }
            return listaJogosRepository.saveAll(listaJogos)
                    .then(Mono.just("OK"));
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
